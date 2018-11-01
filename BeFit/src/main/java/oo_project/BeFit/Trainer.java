package oo_project.BeFit;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

/**
 *
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
    */
   public Trainer(String _name, long _id){
      super(_name, _id);
   }

    /**
     * @param _day mon, tues, wed, thurs, fri, sat, sun
     * @param time 0000 = midnight - 2359 = 11:59pm
     * @param _trainer name of the trainer
     * @param _member name of the member
     * @return instance of a private session
     */
   public PrivateSession addPrivateSession(String _day, int time, Trainer _trainer, Member _member) {
       // TODO implement here
      return null;
   }

   /*
    * @param _day
    * @param time
    * @param _instructor
    * @param _member
    * @return
   */
//   public PrivateSession editPrivateSession(PrivateSession _session, String _day, int time, Trainer _instructor, Member _member) {
//      return false;
//   }


}
