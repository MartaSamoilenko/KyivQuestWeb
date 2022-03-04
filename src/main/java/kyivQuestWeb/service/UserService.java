package kyivQuestWeb.service;

import kyivQuestWeb.model.User;
import kyivQuestWeb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser(User user){
        userRepository.save(user);
    }

    @Override
    public User findByEmail(String email){
        for (User user : userRepository.findAll()){
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User findByPassword(String password){
        for (User user : userRepository.findAll()){
            if (user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    @Override
    public User findByNameAndSurname(String name, String surname){
        for (User user : userRepository.findAll()){
            if (user.getName().equals(name) && user.getSurname().equals(surname)){
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> findAll(){
        return userRepository.findAll();
    }
}
