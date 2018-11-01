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
       id = -1;
   }

    /**
     *
     */
   public String name;

    /**
     *
     */
//   private String password;

   @Id
   private final long id;

    /**
     * @return
     */
   public User(String _name, long _id) {
        name = _name;
        id = _id;

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


}
