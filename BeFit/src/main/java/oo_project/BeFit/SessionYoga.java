package oo_project.BeFit;

public class SessionYoga extends Session {
    /*Default constructor for a yoga session*/
    public SessionYoga(){
        super();
    }
    /*Constructor for a yoga session*/
    public SessionYoga(String _type, String _trainer, String _member, String _day, String _time){
        super(_type, _trainer, _member, _day, _time);
    }
}
