package oo_project.BeFit;
/**Session Cycling class creates a cycling session
 * */
public class SessionCycling extends Session{
    /**Default Constructor*/
    public SessionCycling(){
        super();
    }
    /**Constructor
     * @param _type type of session, which is cycling
     * @param _trainer the trainer who is leading the session
     * @param _member the member who booked the session
     * @param _day day of the session
     * @param _time time of the session
     * */
    public SessionCycling(String _type, String _trainer, String _member, String _day, String _time){
        super(_type, _trainer, _member, _day, _time);
    }
}
