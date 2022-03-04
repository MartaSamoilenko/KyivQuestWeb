package kyivQuestWeb.service;

import kyivQuestWeb.model.UserCompletedRoute;
import kyivQuestWeb.repository.UserCompletedRouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserCompletedRouteService implements IUserCompletedRouteService {

    @Autowired
    UserCompletedRouteRepository userCompletedRouteRepository;

    @Override
    public List<UserCompletedRoute> findAll(){
        return userCompletedRouteRepository.findAll();
    }

    @Override
    public List<UserCompletedRoute> findByUserId(Long id){
        List<UserCompletedRoute> userCompletedRoutes = new ArrayList<>();
        for (UserCompletedRoute userCompletedRoute : userCompletedRouteRepository.findAll()){
            if (userCompletedRoute.getUserid() == id){
                userCompletedRoutes.add(userCompletedRoute);
            }
        }
        return userCompletedRoutes;
    }

    @Override
    public List<UserCompletedRoute> findByRouteId(Long id){
        List<UserCompletedRoute> userCompletedRoutes = new ArrayList<>();
        for (UserCompletedRoute userCompletedRoute : userCompletedRouteRepository.findAll()){
            if (userCompletedRoute.getRouteid() == id){
                userCompletedRoutes.add(userCompletedRoute);
            }
        }
        return userCompletedRoutes;
    }
}
