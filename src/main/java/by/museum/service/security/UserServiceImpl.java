package by.museum.service.security;

import by.museum.entities.security.User;
import by.museum.repositories.security.UserRepository;
import by.museum.service.templates.SimpleServiceImpl;
import org.springframework.stereotype.Service;

/**
 * Created by shamaz on 15.05.2016.
 */

@Service
public class UserServiceImpl extends SimpleServiceImpl<User, UserRepository> implements UserService{

    @Override
    public User getUserByLogin(String login) {
        return repository.findUserByLogin(login);
    }
}
