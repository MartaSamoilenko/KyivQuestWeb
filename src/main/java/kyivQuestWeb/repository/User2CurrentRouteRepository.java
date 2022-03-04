package kyivQuestWeb.repository;

import kyivQuestWeb.model.User2CurrentRoute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User2CurrentRouteRepository extends JpaRepository<User2CurrentRoute, Long> {
}
