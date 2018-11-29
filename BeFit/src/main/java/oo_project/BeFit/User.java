package oo_project.BeFit;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.*;

/**
 * User class is the abstract class for Members and Trainers. It holds name and username
 */

public abstract class User {

    /**
     * Default constructor
     */
   public User() {
       name = "";
       id = "";
   }

    /**
     * Name of the user
     */
   public String name;
    /**
     * Username of the user, their ID
     */
   @Id
   private String id;

    /**
     * Constructor
     * @param _name name of the user
     * @param _username username of the user
     */
   public User(String _name, String _username) {
        name = _name;
        id = _username;
   }

    /** Set the name for the user
     * @param _name of the user
     */
   public void setName(String _name) {
       name = _name;
   }


    /** Get the name of the user
     * @return name of the user
     */
   public String getName() {
        return name;
   }

    /** Get the username of the user
     * @return username of the user
     */
    public String getId() {
        return id;
    }
}
