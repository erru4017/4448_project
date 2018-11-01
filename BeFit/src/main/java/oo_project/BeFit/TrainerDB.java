package oo_project.BeFit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void addTrainer(String _name){
        long _id = getCount()+1;
        Trainer t = new Trainer(_name, _id);
        repo.save(t);
    }







}
