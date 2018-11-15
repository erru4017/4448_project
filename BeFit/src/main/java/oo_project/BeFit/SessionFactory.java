package oo_project.BeFit;

public class SessionFactory {
    public Session getSession(String sessionType, String trainerName, String memberName, String day, int time){
        if (sessionType.equalsIgnoreCase("yoga")){
            return new SessionYoga(sessionType, trainerName, memberName, day, time);
        }
        return null;
    }
}
