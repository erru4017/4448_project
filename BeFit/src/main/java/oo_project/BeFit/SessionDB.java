package oo_project.BeFit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionDB {
    /*
     * This database contains all open sessions, that are available to be booked.
     */
    private final SessionRepository repo;

    @Autowired
    public SessionDB(SessionRepository _repo){
        repo = _repo;
    }


    public void addSession(String _trainer, String _member, String _day, int _time){
        Session s = new Session(_trainer, _member, _day, _time);
        repo.save(s);
    }

    public void removeSession(int _sessionID){
        // TODO remove a session once it is booked
    }



}
