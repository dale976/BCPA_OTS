import java.util.ArrayList;
import java.util.Collections;

/**
 * EventManager Class
 * Controller class responsible for managing events.
 * Provides and interface for various tasks associated with events
 * 
 * NOTE: This is only a partial implementation of the online ticketing system.
 *
 * @author (Alan Dale)
 * @version (06/05/2023)
 */
public class EventManager
{

    private ArrayList<Event> events;

    /**
     * Constructor for objects of class EventManager
     */
    public EventManager()
    {
        this.events = new ArrayList();
    }
    
    /**
    * Creates an Event Class and stores it in the events list
    * 
    * @param String name: name given for the event
    */
    public Event createEvent(String name) {
        int id = events.size();
        Event event = new Event(name, id);
        this.events.add(event);
        return event;
    }
    
    /**
    * Returns a list of event classes that exist in the system
    * 
    * @return ArrayList<Event>: All the events stored in the system
    */
    public ArrayList<Event> getEvents() {
        return events;
    }
    
    /**
    * Returns an event class for a given id
    * 
    * @param int id: id for the event
    * 
    * @return Event: The event with the given id
    */
    public Event getEvent(int id) {
        Event foundEvent = null;
        for (Event event : this.events) {
            if (event.id == id) {
                foundEvent = event;
            }
        }
        return foundEvent;
    }
    

}
