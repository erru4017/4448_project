package oo_project.BeFit;
/**
 * Using the factory design pattern*/

public class SessionFactory {
    /**
     * Get session creates a new session, depending on what type of session the member wants. */

    public Session getSession(String sessionType, String trainerName, String memberName, String day, String time){
        if (sessionType.equalsIgnoreCase("y")){
            return new SessionYoga("Yoga", trainerName, memberName, day, time);
        }
        else if (sessionType.equalsIgnoreCase("c")){
            return new SessionCycling("Cycling", trainerName, memberName, day, time);
        }
        else if (sessionType.equalsIgnoreCase("k")){
            return new SessionKickboxing("Kickboxing", trainerName, memberName, day, time);
        }
        return null;
    }
}
