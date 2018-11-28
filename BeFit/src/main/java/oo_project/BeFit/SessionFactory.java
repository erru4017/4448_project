package oo_project.BeFit;

public class SessionFactory {
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
