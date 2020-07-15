package se.lexicon.fullstack_teaser.data;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.fullstack_teaser.entity.AppUser;

import java.util.Optional;

public interface AppUserRepository extends CrudRepository<AppUser, String> {

    Optional<AppUser> findByEmail(String email);

}
