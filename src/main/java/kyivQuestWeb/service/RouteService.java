package kyivQuestWeb.service;

import kyivQuestWeb.model.Route;
import kyivQuestWeb.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService implements IRouteService {
    @Autowired
    private RouteRepository routeRepository;

    @Override
    public List<Route> findAll(){
        System.out.println(routeRepository.findAll());
        return routeRepository.findAll();
    }

    @Override
    public void create(Route route){
        routeRepository.save(route);
    }

    @Override
    public Route findById(Long id){
        for (Route route : routeRepository.findAll()){
            if (route.getId() == id){
                return route;
            }
        }
        return null;
    }
}
