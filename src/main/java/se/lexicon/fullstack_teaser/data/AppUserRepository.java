package se.lexicon.fullstack_teaser.data;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.fullstack_teaser.entity.AppUser;

public interface AppUserRepository extends CrudRepository<AppUser, String> {
}
