package kyivQuestWeb.service;

import kyivQuestWeb.model.User2CurrentRoute;

import java.util.List;

public interface IUser2CurrentRouteService {
    List<User2CurrentRoute> findAll();

    User2CurrentRoute findByUserId(Long id);

    void add(User2CurrentRoute user2CurrentRoute);
}
