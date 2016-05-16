package by.museum.repositories.security;

import by.museum.entities.security.User;
import by.museum.repositories.template.SimpleRepository;

/**
 * Created by shamaz on 15.05.2016.
 */
public interface UserRepository extends SimpleRepository<User> {

    User findUserByLogin(String login);
}
