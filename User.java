
/**
 * User Class
 * Contains properties associated with a user
 * 
 * NOTE: This is only a partial implementation of the online ticketing system.
 *
 * @author (Alan Dale)
 * @version (06/05/2023)
 */
public class User {
    private Integer id;
    public String username;
    public String name;
    public String email;
    public String contact;
    private UserType type;
    private String password;

    /**
    * Constructor for objects of class UserManager
    */
    public User(String username, String password, Integer id) {
        this.username = username;
        this.password = password;
        this.id = id;
    }
    
    /**
    * Returns the ID of the user
    * 
    * @return Integer id: id of the user
    */
    public Integer getId() {
        return id;
    }
    
    /**
    * Returns the user type
    * 
    * @return UserType: Enum value CONSUMER | AGENT
    */
    public UserType getType() {
        return type;
    }
    
    /**
    * Sets the user type
    * 
    * @param Enum UserType
    */
    public void setType(UserType type) {
        this.type = type;
    }
    
    /**
    * Gets the users current password
    * 
    * @return String: password for the user
    */
    public String getPassword() {
        return password;
    }
    
    /**
    * Sets the users password
    * 
    * @param String password: password for the user
    */
    public void setPassword(String password) {
        this.password = password;
    }
    
    
    /**
    * Values for UserType
    */
    public enum UserType {
        CONSUMER,
        AGENT
    }
}
