package kyivQuestWeb.service;

import kyivQuestWeb.model.Checkpoint;

import java.util.List;

public interface ICheckpointService {
    List<Checkpoint> findAll();

    Checkpoint findByName(String name);

    void addCheckpoint(Checkpoint checkpoint);

    void remove(Long id);

    Checkpoint findById(Long id);
}
