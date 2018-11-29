package oo_project.BeFit;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

/**
 * Trainer class holds information about all the trainers, and extends User class.
 */
@Document(collection = "trainers")
public class Trainer extends User {

    /**
     * Default constructor
     */
   public Trainer(){
      super();
   }
   /**
    * Constructor
    * @param _name name of the trainer
    * @param _username username of the trainer
    */
   public Trainer(String _name, String _username){
      super(_name, _username);
   }



}
