import java.util.ArrayList;
import java.util.Collections;

/**
 * ShowManager Class
 * Controller class responsible for managing shows.
 * Provides and interface for various tasks associated with shows
 * 
 * NOTE: This is only a partial implementation of the online ticketing system.
 *
 * @author (Alan Dale)
 * @version (06/05/2023)
 */
public class ShowManager
{
    
    private ArrayList<Show> shows;

    /**
     * Constructor for objects of class ShowManager
     */
    public ShowManager()
    {
        this.shows = new ArrayList();
    }
    
    /**
    * Creates a Show Class and stores it in the shows list
    * 
    * @param String name: name given for the show
    */
    public Show createShow(String name) {
        int id = shows.size();
        Show show = new Show(name, id);
        this.shows.add(show);
        return show;
    }
    
    /**
    * Removes a show from the show list
    * 
    * @param String name: name given for the show
    * @param int id: id of the show to be removed
    */
    public void removeShow(String name, int id) {
        // This method will remove a show from the ArrayList
    }
    
    /**
    * Updates a show in the show list
    * 
    * @param String name: name given for the show
    * @param int id: id of the show to be updated
    */
    public void updateShow(String name, int id) {
        // This method will update values for a given show.
    }
    
    /**
    * Returns a list of show names
    * 
    * @return ArrayList<String>: names of all the shows stored
    */
    public ArrayList<String> getShowNames() {
        ArrayList<String> showNames = new ArrayList();
        for (Show show : shows) {
            showNames.add(show.name);
        }
        return showNames;
    }
    
    /**
    * Returns a list of show classes that exist between a start and end date
    * 
    * @return ArrayList<Show>: All the shows stored that meet the criteria
    */
    public ArrayList<Show> getShowsInRange(String startDate, String endDate) {
        // Iterate through stored shows and return a new array list of those that
        // meet the date criteria.
        // This is not implemented and just returns an empty array list for now.
        return new ArrayList<Show>();
    }
    
    /**
    * Returns a list of show classes
    * 
    * @return ArrayList<Show>: All the shows stored in the system
    */
    public ArrayList<Show> getShows() {
        return this.shows;
    }
    
    /**
    * Returns a show class for a given name and id
    * 
    * @param String name: show name
    * @param int id: id for the show
    * 
    * @return Show: The show with the given name and id
    */
    public Show getShow(String name, int id) {
        for (Show show : shows) {
            if (name.equals(show.name) && id == show.getId()) {
                return show;
            }
        }
        return null;
    }

    
}
