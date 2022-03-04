package kyivQuestWeb.service;

import kyivQuestWeb.model.User;

import java.util.List;

public interface IUserService {
    void addUser(User user);

    List<User> findAll();

    User findByNameAndSurname(String name, String surname);

    User findByEmail(String email);

    User findByPassword(String password);
}
