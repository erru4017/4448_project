package oo_project.BeFit;

import org.springframework.data.annotation.Id;

import java.util.*;

/**
 *
 */
public abstract class Session {

    /**
     * Default constructor
     */
    public Session() {
        type = "";
        trainer = "";
        member = "";
        sessionID = -1; //trainerID+memberID
        day = "";
        time = 0;
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
     * A member is associated with session
     */
//    private int memberCount;
    /**
     * Each session has a unique id number, which is the trainerID+memberID
     */
    @Id
   public int sessionID;

    /**
     * Mon, Tues, Wed, Thurs, Fri, Sat, Sun
     */
   public String day;
    /**
     *0000 = midnight 2359 = 11:59pm
     */
   public int time;
   /**
    * Constructor
    */
   public Session(String _type, String _trainer, String _member, String _day, int _time) {
       Random random = new Random();
       type = _type;
       trainer = _trainer;
       member = _member;
       sessionID = random.nextInt(); //type+time because unique
       day = _day;
       time = _time;

   }
    public String getType(){
       return type;
    }
    /**
     * @return
     */
   public int getSessionID() {
      return sessionID;
   }

    /**
     * @param _trainer
     * @return
     */
   public void setTrainer(String _trainer) {
      trainer = _trainer;
   }

    /**
     * @return
     */
   public String getTrainer() {
      return trainer;
   }

    /**
     * @param _member
     * @return
     */
   public void setMembers(String _member) {
      member = _member;

   }

    /**
     * @return
     */
   public String getMember() {
      return member;
   }

    /**
     * @param _day
     * @return
     */
   public void setDay(String _day) {
      day = _day;

   }

    /**
     * @return day of the week
     */
   public String getDay() {
      return day;
   }

    /**
     * @param _time
     * @return
     */
   public void setTime(int _time) {
      time = _time;
   }

    /**
     * @return
     */
   public int getTime() {
      return time;
   }

}
