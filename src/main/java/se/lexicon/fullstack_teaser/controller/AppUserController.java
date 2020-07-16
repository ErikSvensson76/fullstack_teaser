package se.lexicon.fullstack_teaser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import se.lexicon.fullstack_teaser.data.AppUserRepository;
import se.lexicon.fullstack_teaser.dto.AppUserDTOForm;
import se.lexicon.fullstack_teaser.dto.UpdateForm;
import se.lexicon.fullstack_teaser.entity.AppUser;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class AppUserController {

    private final AppUserRepository appUserRepository;

    @Autowired
    public AppUserController(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @GetMapping("/people")
    public String find(Model model){
        List<AppUser> appUsers = (List<AppUser>) appUserRepository.findAll();
        model.addAttribute("userList", appUsers);
        return "user_control";
    }

    @GetMapping("/people/register")
    public String getForm(Model model){
        AppUserDTOForm appUserDTOForm = new AppUserDTOForm();
        model.addAttribute("form", appUserDTOForm);
        return "user_form";
    }

    @PostMapping("/people/register")
    public String processForm(@Valid @ModelAttribute("form") AppUserDTOForm form, BindingResult bindingResult){
        if(appUserRepository.findByEmail(form.getEmail()).isPresent()){
            FieldError error = new FieldError("form", "email", "Email " + form.getEmail() + " is already taken");
            bindingResult.addError(error);
        }

        if(!form.getPassword().equals(form.getConfirm())){
            FieldError error = new FieldError("form","confirm","Password and confirm field didn't match");
            bindingResult.addError(error);
        }

        if(bindingResult.hasErrors()){
            return "user_form";
        }

        AppUser appUser = new AppUser(
                null,
                form.getFirstName(),
                form.getFirstName(),
                form.getEmail(),
                form.getPassword(),
                form.getBirthDate(),
                LocalDate.now()
        );

        appUser = appUserRepository.save(appUser);
        return "redirect:/people/"+appUser.getUserId();
    }

    @GetMapping("/people/{id}")
    public String findById(@PathVariable("id") String userId, Model model){
        AppUser user = appUserRepository.findById(userId)
                .orElseThrow(RuntimeException::new);

        model.addAttribute("user", user);
        return "user_view";
    }

    @PostMapping("/people/{id}/delete")
    public String deleteById(@PathVariable("id") String userId){
        appUserRepository.deleteById(userId);
        return "redirect:/people";
    }

    @GetMapping("/people/{id}/update")
    public String getUpdateForm(@PathVariable("id") String userId, Model model){
        AppUser appUser = appUserRepository.findById(userId)
                .orElseThrow(RuntimeException::new);

        UpdateForm appUserDTOForm = new UpdateForm();
        appUserDTOForm.setUserId(appUser.getUserId());
        appUserDTOForm.setFirstName(appUser.getFirstName());
        appUserDTOForm.setLastName(appUser.getLastName());
        appUserDTOForm.setEmail(appUser.getEmail());
        appUserDTOForm.setBirthDate(appUser.getBirthDate());

        model.addAttribute("form", appUserDTOForm);
        return "update_form";
    }

    @PostMapping("/people/{id}/update")
    public String processUpdate(@PathVariable("id") String userId, @Valid @ModelAttribute("form") UpdateForm form, BindingResult bindingResult){
        if(!userId.equals(form.getUserId())){
            throw new RuntimeException();
        }

        AppUser appUser = appUserRepository.findById(userId).orElseThrow(RuntimeException::new);

        Optional<AppUser> temp = appUserRepository.findByEmail(form.getEmail());
        if(temp.isPresent()){
            if(!appUser.getUserId().equals(temp.get().getUserId())){
                FieldError error = new FieldError("form", "email", "Email is already taken");
                bindingResult.addError(error);
            }
        }

        if(bindingResult.hasErrors()){
            return "update_form";
        }

        appUser.setFirstName(form.getFirstName());
        appUser.setLastName(form.getLastName());
        appUser.setEmail(form.getEmail());
        appUser.setBirthDate(form.getBirthDate());

        appUserRepository.save(appUser);

        return "redirect:/people/"+appUser.getUserId();
    }

}
