package se.lexicon.fullstack_teaser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import se.lexicon.fullstack_teaser.data.AppUserRepository;
import se.lexicon.fullstack_teaser.entity.AppUser;

import java.util.List;

@Controller
public class AppUserController {

    private AppUserRepository appUserRepository;

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


}
