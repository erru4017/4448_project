package oo_project.BeFit;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.*;

/**
 *
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
     *
     */
   public String name;

   @Id
   private String id;

    /**
     * @return
     */
   public User(String _name, String _username) {
        name = _name;
        id = _username;

   }

    /**
     * @param _name of the user
     */
   public void setName(String _name) {
        name = _name;

   }


    /**
     * @return name of the user
     */
   public String getName() {
        return name;
   }

    /**
     * @return username of the user
     */
    public String getId() {
        return id;
    }
}
