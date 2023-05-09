import java.util.ArrayList;

/**
 * Show Class
 * Contains properties associated with a Show
 * 
 * NOTE: This is only a partial implementation of the online ticketing system.
 *
 * @author (Alan Dale)
 * @version (06/05/2023)
 */
public class Show
{
    public String name;
    public String endTime;
    public String startTime;
    public int maximumSeats;
    private int id;
    private ArrayList<String> availableDates;

    /**
     * Constructor for objects of class Show
     */
    public Show(String name, int id)
    {
        this.name = name;
        this.id = id;
    }
    
    /**
    * Returns the ID of the show
    * 
    * @return int id: id of the show
    */
    public int getId() {
        return id;
    }

    /**
    * Returns a list of dates
    * 
    * @return ArrayList<String> availableDates: returns all available dates for the show
    */
    public ArrayList<String> getAvailableDates() {
        return availableDates;
    }

    /**
    * Sets the available dates of the show
    * 
    * @param ArrayList<String> availableDates: Strings of dates
    */
    public void setAvailableDates(ArrayList<String> availableDates) {
        this.availableDates = availableDates;
    }

    /**
    * Returns the end time of the show
    * 
    * @return String endTime: End time
    */
    public String getEndTime() {
        return endTime;
    }

    /**
    * Sets the end time of the show
    * 
    * @param String endTime: End time of the show
    */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
    * Gets the start time of the show
    * 
    * @return String startTime: Start time of the show
    */
    public String getStartTime() {
        return startTime;
    }

    /**
    * Sets the start time of the show
    * 
    * @param String startTime: Start time of the show
    */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    
    /**
    * Sets the maximum seats for the show
    * 
    * @return int maximumSeats: Number of seats
    */
    public int getMaximumSeats() {
        return maximumSeats;
    }

    /**
    * Sets the maximum seats for the show
    * 
    * @param int maximumSeats: Number of seats
    */
    public void setMaximumSeats(int maximumSeats) {
        this.maximumSeats = maximumSeats;
    }
}
