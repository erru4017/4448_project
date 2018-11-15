package oo_project.BeFit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static javafx.scene.input.KeyCode.S;

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


    public void addSession(String sessionType, String _trainer, String _member, String _day, int _time){
        Session s = null;
        if (sessionType.equalsIgnoreCase("yoga")) {
            s = new SessionYoga(sessionType, _trainer, _member, _day, _time);
        }
        repo.save(s);
    }

    public void removeSession(int _sessionID){
        // TODO remove a session once it is booked
    }
    private void printSession(String sessionType, String _trainer, String _member, String _day, int _time){
        System.out.println("_____________________");
        System.out.println(sessionType);
        System.out.println(_time + " " +_day);
        System.out.println("Trainer: " + _trainer);
        System.out.println("Member: " + _member);
        System.out.println("_____________________");
    }
    public void printAllSessions(){
        List<Session> result = repo.findAll();
        for (Session s : result){
            printSession(s.getType(), s.getTrainer(), s.getMember(), s.getDay(), s.getTime());
        }

//        return result.orElse(null);

    }



}
