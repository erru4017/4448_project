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

   /*
    * Constructor
    */
   public Trainer(String _name, long _id){
      super(_name, _id);
   }

    /*
     * @param _day mon, tues, wed, thurs, fri, sat, sun
     * @param time 0000 = midnight - 2359 = 11:59pm
     * @param _trainer name of the trainer
     * @param _member name of the member
     * @return instance of a private session
     */
   public boolean addSession(String _trainer, String _member, String _day, int _time) {
       // TODO add a session that members can book to the database. call function from SessionDB.java
      return true;
   }

   /*
    * @param _day
    * @param time
    * @param _instructor
    * @param _member
    * @return
   */
   public Session editSession(Session _session, String _trainer, String _member, String _day, int _time) {
      //TODO trainers can edit a session to change the trainer, member, day or time.
      return null;
   }


}
