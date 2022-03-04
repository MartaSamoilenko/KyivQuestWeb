package kyivQuestWeb.repository;

import kyivQuestWeb.model.UserCompletedRoute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCompletedRouteRepository extends JpaRepository<UserCompletedRoute, Long> {
}
