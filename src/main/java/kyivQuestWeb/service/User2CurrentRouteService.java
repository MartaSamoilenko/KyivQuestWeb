package kyivQuestWeb.service;

import kyivQuestWeb.model.User2CurrentRoute;
import kyivQuestWeb.repository.User2CurrentRouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User2CurrentRouteService implements IUser2CurrentRouteService {

    @Autowired
    private User2CurrentRouteRepository user2CurrentRouteRepository;

    @Override
    public List<User2CurrentRoute> findAll() {
        return user2CurrentRouteRepository.findAll();
    }

    @Override
    public User2CurrentRoute findByUserId(Long id){
        for (User2CurrentRoute user2CurrentRoute : user2CurrentRouteRepository.findAll()){
            if(user2CurrentRoute.getCurrentuserid() == id){
                return user2CurrentRoute;
            }
        }
        return null;
    }

    @Override
    public void add(User2CurrentRoute user2CurrentRoute){
        user2CurrentRouteRepository.save(user2CurrentRoute);
    }
}
