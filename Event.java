import java.util.ArrayList;

/**
 * Event Class
 * Contains properties associated with an Event
 * 
 * NOTE: This is only a partial implementation of the online ticketing system.
 *
 * @author (Alan Dale)
 * @version (06/05/2023)
 */
public class Event
{
    public int id;
    public String name;
    public String description;
    private ArrayList<Show> shows;

    /**
     * Constructor for objects of class Event
     * 
     * @param String name: event name
     * @param int id: event id
     */
    public Event(String name, int id)
    {
        this.id = id;
        this.name = name;
        this.shows = new ArrayList();
    }
    
    /**
     * Add a show to the event
     * 
     * @param Show show: instance of a show
     */
    public void addShow(Show show) {
        this.shows.add(show);
    }
    
    /**
     * Add shows to the event
     * 
     * @param ArrayList<Show> shows: Array List of show classes
     */
    public void addShows(ArrayList<Show> shows) {
        this.shows = shows;
    }
    
    /**
     * Returns shows for the event
     * 
     * @return ArrayList<Show> shows: Collection of shows attached to the event
     */
    public ArrayList<Show> getShows() {
        return this.shows;
    }
    
    /**
     * Remove a show from the event
     * 
     * @param int id: id of show to be removed
     */
    public void removeShow(int id) {
        for (Show show : shows) {
            if (id == (show.getId())) {
                this.shows.remove(show);
            }
        }
    }
    
    /**
     * Returns the event id as a string
     * 
     * @return String id: id as a string
     */
    public String getIdString() {
        return Integer.toString(this.id);
    }
    
}
