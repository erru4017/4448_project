package oo_project.BeFit;

import org.springframework.data.annotation.Id;

import java.util.*;

/**
 * The session class holds information regarding each session of the gym.
 */
public abstract class Session {

    /**
     * Default constructor
     */
    public Session() {
        type = "";
        trainer = "";
        member = "";
        sessionID = "";
        day = "";
        time = "";
   }
   public String type;

   /**
    * A trainer is associated with sessions
    */
   public String trainer;
    /**
     * A member is associated with session
     */
   public String member;
    /**
     * Each session has a unique id number, which is the trainerID+memberID
     */
    @Id
   public String sessionID;

    /**
     * Mon, Tues, Wed, Thurs, Fri, Sat, Sun
     */
   public String day;
    /**
     *0000 = midnight 2359 = 11:59pm
     */
   public String time;
   /**
    * Constructor
    */
   public Session(String _type, String _trainer, String _member, String _day, String _time) {
       type = _type;
       trainer = _trainer;
       member = _member;
       sessionID = _trainer + _day + _time; //type+time because unique
       day = _day;
       time = _time;

   }
    /**
     * @return type of session
     */

    public String getType(){
       return type;
    }
    /**
     * @return session ID
     */
   public String getSessionID() {
      return sessionID;
   }

    /**
     * @param _trainer set the name of the trainer for the session
     */
   public void setTrainer(String _trainer) {
      trainer = _trainer;
   }

    /**
     * @return trainer of the session
     */
   public String getTrainer() {
      return trainer;
   }

    /**
     * @param _member set the member for the session
     *
     */
   public void setMember(String _member) {
      member = _member;
   }

    /**
     * @return member of the session
     */
   public String getMember() {
      return member;
   }

    /**
     * @param _day day of the week for the session
     *
     */
   public void setDay(String _day) {
      day = _day;
   }

    /**
     * @return day of the week for the session
     */
   public String getDay() {
      return day;
   }

    /**
     * @param _time time of the session
     */
   public void setTime(String _time) {
      time = _time;
   }

    /**
     * @return time of the session
     */
   public String getTime() {
      return time;
   }

}
