package kyivQuestWeb.service;

import kyivQuestWeb.model.Checkpoint;
import kyivQuestWeb.model.Route2Checkpoint;
import kyivQuestWeb.repository.Route2CheckpointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Route2CheckpointService implements IRoute2CheckpointService{
    @Autowired
    private Route2CheckpointRepository route2CheckpointRepository;

    @Override
    public List<Route2Checkpoint> findAll(){
        return route2CheckpointRepository.findAll();
    }

    @Override
    public void createWithList(long routeId, List<Checkpoint> checkpoints){
        for (Checkpoint checkpoint : checkpoints){
            Route2Checkpoint route2Checkpoint = new Route2Checkpoint();
            route2Checkpoint.setRouteid(routeId);
            route2Checkpoint.setCheckpointid(checkpoint.getId());
            route2CheckpointRepository.save(route2Checkpoint);
        }
    }

    @Override
    public void createWithCheckpoint(long routeId, long checkpointId){
        Route2Checkpoint route2Checkpoint = new Route2Checkpoint();
        route2Checkpoint.setCheckpointid(checkpointId);
        route2Checkpoint.setRouteid(routeId);
        route2CheckpointRepository.save(route2Checkpoint);
    }

    @Override
    public List<Route2Checkpoint> findByRouteId(Long routeId){
        List<Route2Checkpoint> route2Checkpoints = new ArrayList<>();
        for (Route2Checkpoint route2Checkpoint : route2CheckpointRepository.findAll()){
            if (route2Checkpoint.getRouteid() == routeId){
                route2Checkpoints.add(route2Checkpoint);
            }
        }
        return route2Checkpoints;
    }

    @Override
    public List<Checkpoint> findCheckpointsByRouteId(Long routeId){
        List<Checkpoint> checkpoints = new ArrayList<>();
        for (Route2Checkpoint route2Checkpoint : findByRouteId(routeId)){
            checkpoints.add(route2Checkpoint.getCheckpoint());
        }
        return checkpoints;
    }
}
