package se.lexicon.fullstack_teaser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.fullstack_teaser.data.AppUserRepository;
import se.lexicon.fullstack_teaser.entity.AppUser;

import java.time.LocalDate;

@Component
public class CommandLine implements CommandLineRunner {

    private AppUserRepository appUserRepository;

    @Autowired
    public CommandLine(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        AppUser appUser = new AppUser(
                null,
                "Erik",
                "Svensson",
                "erik.svensson@lexicon.se",
                "1234",
                LocalDate.parse("1976-09-11"),
                LocalDate.now()
        );
        appUser = appUserRepository.save(appUser);
        System.out.println(appUser);
    }
}
