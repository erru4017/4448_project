package oo_project.BeFit;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.*;

/**
 * The member class holds information regarding each member of the gym.
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
     * Punch pass for a member, used to book sessions.
     */
   public int punchPass;
   /**
    * Constructor
    */
   public Member(String _name, String _username) {
       super(_name, _username);
       punchPass = 0; //start at 0 punches when they are created.
   }

    /** a member will pick how many punches to buy, then that will be added to their punch pass total.
     * @param _punchPass how many punches they currently have
     * @param howMany how many punches to buy
     */
   public void buyPunchPass(int _punchPass, int howMany) {
       this.punchPass = _punchPass + howMany;
   }
    /** Get the number of punch passes a member has on their account.
     * @return number of punches the member has
     */
   public int getPunchPass() {
      return punchPass;
   }
    /** Set a punch pass to a specific value
     * @param _punchPass: new value of punch pass
     */

    public void setPunchPass(int _punchPass) { punchPass = _punchPass; }


}
