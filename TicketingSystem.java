import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * TicketingSystem Class
 * Main class responsible for instantiating component/controller classes and providing an interface between them.
 * Also acts as the connecting class between the user interface and the system.
 * 
 * NOTE: This is only a partial implementation of the online ticketing system.
 *
 * @author (Alan Dale)
 * @version (06/05/2023)
 */
public class TicketingSystem
{

    private UserManager userManager;
    private EventManager eventManager;
    private ShowManager showManager;

    /**
    * Constructor for objects of class TicketingSystem
    */
    public TicketingSystem()
    {
        this.userManager = new UserManager();
        this.eventManager = new EventManager();
        this.showManager = new ShowManager();
        
        // run test setup
        this.setUpTestData();
    }
    
    /**
     * Public method to sign in
     */
    public void signIn(String username, String password) throws Exception {
        this.userManager.signIn(username, password);
    }
    
    /**
     * Public method to sign out
     */
    public void signOut() {
        this.userManager.signOut();
    }
    
    /**
     * Public method to create a user
     */
    public void createUser(String username, String password) {
        this.userManager.createUser(username, password);
    }
    
    /**
     * Public method to verify if a user is signed in
     * 
     * @return boolean: true | false
     */
    public boolean isSignedIn() {
        return this.userManager.isSignedIn;
    }
    
    /**
     * Public method to get the stored events in the system
     * 
     * @return ArrayList<Event>: List of events that exist in the system
     */
    public ArrayList<Event> getEvents() {
        return this.eventManager.getEvents();
    }
    
    /**
     * Public method to get a single event
     * 
     * @param int id: the identifier of the event requested
     * @return Event: An instance of the event class
     */
    public Event getEvent(int id) {
        return this.eventManager.getEvent(id);
    }
    
    
    /**
     * Private method to populate the system with test data.
     * Creates a series of events with multiple showings and relevant metadata
     * to be used whilst testing the system
     */
    private void setUpTestData() {
        // Create a matinee and evening showing
        ArrayList<String> showNames = new ArrayList();
        String[] showings = {"Matinee","Evening"};
        Collections.addAll(showNames, showings);
        ArrayList<Show> shows = new ArrayList();
        
        // For now, just create a matinee and evening showing for every event with a given time and set maximum number of seats
        // This will be dynamically created when a manager creates events and shows.
        for(String name : showings) {
            boolean isMatinee = name.equals("Matinee");
            Show show = this.showManager.createShow(name);
            show.maximumSeats = isMatinee ? 100 : 150;
            show.startTime = isMatinee ? "13:00" : "19:00";
            show.endTime = isMatinee ? "15:00" : "21:00";
            shows.add(show);
        }
        
        // Create some test events and add the showings
        ArrayList<String> eventNames = new ArrayList();
        String[] events = {"Lion King","School of Rock", "Hamilton", "Wicked", "Frozen", "Book of Mormon", "Cats"};
        Collections.addAll(eventNames, events);
        for(String name : eventNames) {
            Event event = this.eventManager.createEvent(name);
            event.description = this.getDescription(name);
            event.addShows(shows);
        }        
    }
    
    /**
     * Private method to populate event descriptions
     * 
     * @param String name: Name of the event requested
     * @return String: Description text of the requested event
     */
    private String getDescription(String name) {
        HashMap<String, String> showDescriptions = new HashMap<String, String>();    
        showDescriptions.put("Lion King","The Lion King Broadway musical is an adaptation of the 1994 Disney animated movie with expanded story, new songs and stunning costumes and puppetry. It follows the same basic plot as the movie with a greater emphasis on African culture, and has become one of the most successful musicals of all time, winning multiple Tony Awards.");
        showDescriptions.put("School of Rock","School of Rock Broadway musical is based on the 2003 film and follows Dewey Finn, a substitute teacher who forms a rock band with his students to compete in a music competition. The musical features music by Andrew Lloyd Webber and has received critical acclaim for its high-energy performances and talented child actors.");
        showDescriptions.put("Hamilton","Hamilton Broadway musical is created by Lin-Manuel Miranda and tells the story of Alexander Hamilton using hip-hop, R&B, and traditional show tunes. It explores themes of ambition, love, and political power and features a diverse cast portraying historical figures. 'Hamilton' has received critical acclaim for its innovative storytelling, music, and casting, and has won numerous awards including 11 Tony Awards and a Pulitzer Prize for Drama.");
        showDescriptions.put("Wicked","Wicked Broadway musical is based on the novel by Gregory Maguire and tells the story of the witches of Oz, specifically Elphaba and Glinda, and their unlikely friendship. The show features music and lyrics by Stephen Schwartz and is known for its impressive visual effects and catchy songs. 'Wicked' has become one of the most successful musicals of all time and has won multiple Tony Awards.");
        showDescriptions.put("Frozen","Frozen Broadway musical is based on the 2013 Disney animated movie and tells the story of two sisters, Anna and Elsa, separated by Elsa's magical powers. The musical features music and lyrics by Kristen Anderson-Lopez and Robert Lopez, including the hit song 'Let It Go.' 'Frozen' has received critical acclaim for its stunning visual effects, catchy songs, and strong performances and has won multiple Tony Awards.");
        showDescriptions.put("Book of Mormon","The Book of Mormon Broadway musical is created by Trey Parker, Matt Stone, and Robert Lopez and tells the story of two young Mormon missionaries sent to Uganda to spread the word of the Mormon religion. The show features irreverent humor and catchy songs and satirizes organized religion, traditional musical theater, and American culture. The Book of Mormon has won multiple Tony Awards, including Best Musical.");
        showDescriptions.put("Cats","Cats Broadway musical is based on T.S. Eliot's poetry collection and tells the story of a tribe of cats who gather for their annual Jellicle Ball to decide which cat will ascend to the Heaviside Layer and be reborn into a new life. The musical features music by Andrew Lloyd Webber and iconic songs such as Memory. Cats has won multiple Tony Awards and is known for its imaginative set design, intricate choreography, and memorable characters.");
        return showDescriptions.get(name);   
    }
    
}
