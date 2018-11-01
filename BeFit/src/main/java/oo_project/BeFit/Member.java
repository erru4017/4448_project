package oo_project.BeFit;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;


/**
 *
 */
@Document(collection = "members")
public class Member extends User {

    /**
     * Default constructor
     */
    public Member() {
        super();
        punchPass = 0;
    }

    /**
     *
     */
   public int punchPass;
   /**
    * Constructor
    */
   public Member(String _name, long _id) {
       super(_name, _id);
       punchPass = 0; //start at 0 punches when they are created.

   }

    /*
     * @param _punchPass how many punches they currently have
     * @param _howMany how many punches to buy
     *
     */
   public void buyPunchPass(int _punchPass, int _howMany) {
      // TODO a member will pick how many punches to buy, then that will be added to their punch pass total.
   }

    /*
     * @return number of punches the member has
     */
   public int getPunchPass() {
      return punchPass;
   }

    /*
     * @param _day
     * @param time
     * @param _trainer
     * @param _member
     * @return
     */
    public void viewSchedule(){
        // TODO view all open sessions in the database
    }


    /*
     * @param _day
     * @param time
     * @param _trainer
     * @param _member
     * @return
     */
   public boolean bookSession(int _sessionID) {
        // TODO member can book a session, given an id. It will then be removed from the database.
      return true;
   }

}
