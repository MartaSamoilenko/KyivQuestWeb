package kyivQuestWeb.service;

import kyivQuestWeb.model.UserCompletedRoute;

import java.util.List;

public interface IUserCompletedRouteService {

    List<UserCompletedRoute> findAll();

    List<UserCompletedRoute> findByUserId(Long id);

    List<UserCompletedRoute> findByRouteId(Long id);
}
