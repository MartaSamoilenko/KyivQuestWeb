package kyivQuestWeb.service;

import kyivQuestWeb.model.Checkpoint;
import kyivQuestWeb.model.Route2Checkpoint;

import java.util.List;

public interface IRoute2CheckpointService {
    List<Route2Checkpoint> findAll();

    void createWithList(long routeId, List<Checkpoint> checkpoints);

    void createWithCheckpoint(long routeId, long checkpointId);

    List<Route2Checkpoint> findByRouteId(Long routeId);

    List<Checkpoint> findCheckpointsByRouteId(Long routeId);
}
