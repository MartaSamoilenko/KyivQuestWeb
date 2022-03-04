package kyivQuestWeb.service;

import kyivQuestWeb.model.Route;

import java.util.List;

public interface IRouteService {
    List<Route> findAll();

    void create(Route route);

    Route findById(Long id);
}
