package by.museum.service.security;

import by.museum.entities.security.User;
import by.museum.service.templates.SimpleService;

/**
 * Created by shamaz on 15.05.2016.
 */
public interface UserService extends SimpleService<User>{

    /**
     * Возвращает сущность User по его полю login
     * @param login login, по которому нужно вернуть пользователя
     * @return User
     */
    User getUserByLogin(String login);
}
