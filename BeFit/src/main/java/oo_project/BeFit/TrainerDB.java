package oo_project.BeFit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainerDB {
    private final TrainerRepository repo;

    @Autowired
    public TrainerDB(TrainerRepository _repo){
        repo = _repo;
    }

    public long getCount(){
        return repo.count();
    }

    public void addTrainer(String _name, String _id){
//        long _id = getCount()+1;
        Trainer t = new Trainer(_name, _id);
        repo.save(t);
    }

    public Trainer retrieveTrainer(String _username){
        Optional<Trainer> result = repo.findById(_username);
        return result.orElse(null);

    }








}
