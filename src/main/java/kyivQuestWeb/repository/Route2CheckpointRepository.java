package kyivQuestWeb.repository;

import kyivQuestWeb.model.Route2Checkpoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Route2CheckpointRepository extends JpaRepository<Route2Checkpoint, Long> {
}
