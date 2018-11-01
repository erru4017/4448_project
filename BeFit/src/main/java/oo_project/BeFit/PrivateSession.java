package oo_project.BeFit;

import java.util.*;

/**
 *
 */
public class PrivateSession {

    /**
     * Default constructor
     */
    public PrivateSession() {
        trainer = null;
        member = null;
        sessionID = -1; //trainerID+memberID
        day = "";
        time = 0;
   }
   /**
    * A trainer is associated with sessions
    */
   public Trainer trainer;
    /**
     * A member is associated with session
     */
   public Member member;
    /**
     * Each session has a unique id number, which is the trainerID+memberID
     */
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
   public PrivateSession(Trainer _trainer, Member _member, int _sessionID, String _day, int _time) {
       trainer = _trainer;
       member = _member;
       sessionID = _sessionID; //trainerID+memberID
       day = _day;
       time = _time;

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
   public void setTrainer(Trainer _trainer) {
      trainer = _trainer;

   }

    /**
     * @return
     */
   public Trainer getTrainer() {
      return trainer;
   }

    /**
     * @param _member
     * @return
     */
   public void setMember(Member _member) {
      member = _member;

   }

    /**
     * @return
     */
   public Member getMember() {
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
     * @return
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
