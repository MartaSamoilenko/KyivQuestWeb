package kyivQuestWeb.service;

import kyivQuestWeb.model.Checkpoint;
import kyivQuestWeb.repository.CheckpointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckpointService implements ICheckpointService{

    @Autowired
    CheckpointRepository checkpointRepository;

    @Override
    public List<Checkpoint> findAll(){
        return checkpointRepository.findAll();
    }

    @Override
    public void addCheckpoint(Checkpoint checkpoint){
        checkpointRepository.save(checkpoint);
    }

    @Override
    public Checkpoint findByName(String name){
        for (Checkpoint checkpoint : checkpointRepository.findAll()){
            if (checkpoint.getName().equals(name)){
                return checkpoint;
            }
        }
        return null;
    }

    @Override
    public Checkpoint findById(Long id){
        for(Checkpoint checkpoint : checkpointRepository.findAll()){
            if(checkpoint.getId() == id){
                return checkpoint;
            }
        }
        return null;
    }

    @Override
    public void remove(Long id){
        checkpointRepository.deleteById(id);
    }
}
