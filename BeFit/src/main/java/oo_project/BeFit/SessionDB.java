package oo_project.BeFit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static javafx.scene.input.KeyCode.S;
/**
 * SessionDB class contains methods regarding sessions*/
@Service
public class SessionDB {
    /**
     * This database contains all booked sessions.
     */
    private final SessionRepository repo;
    /**
     * Set the repository.
     */
    @Autowired
    public SessionDB(SessionRepository _repo){
        repo = _repo;
    }
    /**
     * Add a sessions to the database.
     * @param s The session object to add to the database
     */
    public void addSession(Session s){
        repo.save(s);
    }
    /**
     * Delete a session from the database.
     * @param _sessionID The session ID of the session to be deleted
     */
    public void removeSession(String _sessionID){
        repo.deleteById(_sessionID);
    }
    /**
     * Print a session from the database.
     * @param sessionType The type of the session
     * @param _trainer The trainer who is leading the session
     * @param _member The member who booked the session
     * @param _day The day of the week for the session
     * @param _time Time of the session
     */
    private void printSession(String sessionType, String _trainer, String _member, String _day, String _time){
        System.out.println("_____________________");
        System.out.println(sessionType);
        System.out.println(_day + " at " +_time);
        System.out.println("Trainer: " + _trainer);
        System.out.println("Member: " + _member);
        System.out.println("_____________________");
    }
    /**
     * Retrieve all sessions from the database and print them all out.
     */

    public void printAllSessions(){
        List<Session> result = repo.findAll();
        for (Session s : result){
            printSession(s.getType(), s.getTrainer(), s.getMember(), s.getDay(), s.getTime());
        }
    }
    /**
     * Check if a session with a certain trainer, on a certain day and time already exists.
     * @param id of the session
     * @return true if the session exists already
     */

    public boolean exists(String id){
        return repo.existsById(id);
    }


}
