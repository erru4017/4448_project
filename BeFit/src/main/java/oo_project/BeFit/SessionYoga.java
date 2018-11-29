package oo_project.BeFit;
/**Session Yoga class creates a cycling session
 * */

public class SessionYoga extends Session {
    /*Default constructor for a yoga session*/
    public SessionYoga(){
        super();
    }
    /**Constructor
     * @param _type type of session, which is yoga
     * @param _trainer the trainer who is leading the session
     * @param _member the member who booked the session
     * @param _day day of the session
     * @param _time time of the session
     * */

    public SessionYoga(String _type, String _trainer, String _member, String _day, String _time){
        super(_type, _trainer, _member, _day, _time);
    }
}
