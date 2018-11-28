package oo_project.BeFit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**
 * TrainerDB class contains methods regarding sessions*/

@Service
public class TrainerDB {
    /**
     * This database contains all booked sessions.
     */
    private final TrainerRepository repo;
    /**
     * Set the repository.
     */

    @Autowired
    public TrainerDB(TrainerRepository _repo){
        repo = _repo;
    }
    /**
     * Get the total number of trainers in the database.
     * @return the total in the database
     */
    public long getCount(){
        return repo.count();
    }
    /**
     * Add a trainer to the database.
     * @param _name of the trainer
     * @param _id is the trainer's username
     */
    public void addTrainer(String _name, String _id){
        Trainer t = new Trainer(_name, _id);
        repo.save(t);
    }
    /**
     * Find a trainer in the database.
     * @param _username of the trainer
     * @return the trainer with that username
     */
    public Trainer retrieveTrainer(String _username){
        Optional<Trainer> result = repo.findById(_username);
        return result.orElse(null);
    }
    /**
     * Print a trainer in the database.
     * @param name of the trainer
     */

    private void printTrainer(String name){
        System.out.println(name);
    }
    /**
     * Print all trainers in the database.
     */
    public void printAllTrainers(){
        List<Trainer> result = repo.findAll();
        for (Trainer t : result){
            printTrainer(t.getName());
        }
    }









}
