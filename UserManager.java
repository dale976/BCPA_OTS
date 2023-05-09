import java.util.ArrayList;

/**
 * UserManager Class
 * Controller class responsible for managing users.
 * Provides and interface for various tasks associated with users
 * 
 * NOTE: This is only a partial implementation of the online ticketing system.
 *
 * @author (Alan Dale)
 * @version (06/05/2023)
 */
public class UserManager {
    private ArrayList<User> users;
    public boolean isSignedIn;

    /**
    * Constructor for objects of class UserManager
    */
    public UserManager() {
        this.users = new ArrayList<>();
        this.isSignedIn = false;
    }
    
    /**
    * Creates a User Class and stores it in the users list
    * 
    * @param String Username: name given by the user
    * @param String Password: password given by the user
    */
    public void createUser(String userName, String password) {
        int id = users.size();
        User user = new User(userName, password, id);
        users.add(user);
    }
    
    /**
    * Signs the user into the system
    * 
    * @param String username: username for the user
    * @param String password: password for the user
    * 
    * @throws Exception: Throws an error when trying to sign in when no users exist in the system
    */
    public void signIn(String username, String password) throws Exception {
        // For now, if there are no users in the system then throw an exception which is caught 
        // further up at the parent level. This class does not care for how the exception is handled by the system 
        // as no UI is attached to this class.
        if (users.size() == 0) {
            System.out.println("Error. No users exist on the system. Please register a new user.");
            throw new Exception("Error. No users exist on the system. Please register a new user.");
        }
        
        for(User user : users) {
            if(username.equals(user.username) && password.equals(user.getPassword())) {
                this.isSignedIn = true;
                System.out.println("signed user in successfully");
            } else {
                System.out.println("username or password incorrect, are you sure you have an account?");
                this.isSignedIn = false;
            }
        }
    }
    
    /**
    * Signs the current user out of the system
    */
    public void signOut() {
        if (this.isSignedIn == true) {
            this.isSignedIn = false;
            System.out.println("logged user out successfully");    
        }
    }
    
    /**
    * Verifies if a username exists in the system
    */
    public boolean verifyUser(String userName) {
        for (User user : users) {
            if (userName.equals(user.username)) {
                return true;
            }
        }
        return false;
    }
}






