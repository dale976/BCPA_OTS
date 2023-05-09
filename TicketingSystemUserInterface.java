import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * User Interface for the Online Ticketing System. This interface allows for user sign in, user registration
 * and allows a user to view all events and the details for a particular event. This interface is connected to
 * the TicketingSystem Class.
 * 
 * NOTE: This is only a partial implementation of the online ticketing system.
 *
 * @author (Alan Dale)
 * @version (06/05/2023)
 */
public class TicketingSystemUserInterface
{
    /**
     * An example of a method header - replace this comment with your own
     *
     * @param  y a sample parameter for a method
     * @return   the result produced by sampleMethod
     */
    
    private TicketingSystem ticketingSystem;
    private JFrame frame;
    private JButton signInButton;
    private JButton signOutButton;
    private JButton registerButton;
    
    private JPanel signInPanel;
    private JPanel eventListPanel;
    private JPanel eventDetailsPanel;
    
    private int selectedEventId;
    private boolean signedIn;
    
    
    /**
    * Class constructor
    * Responsible to instantiating the TicketingSystem class 
    * and begin the drawing process
    */
    public TicketingSystemUserInterface() {
        this.ticketingSystem = new TicketingSystem();
        this.signedIn = false;
        makeFrame();
    }

    /**
    * Sets up the UI
    */
    public void makeFrame() {
       // Create a JFrame to hold the panels
        JFrame frame = new JFrame("Bucks Uni Online Ticketing System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(1280,720));
        frame.setLayout(new BorderLayout());

        // Create a JPanel for each panel
        signInPanel = new JPanel();
        eventListPanel = new JPanel();
        eventDetailsPanel = new JPanel();

        // Set the layout for each panel
        eventListPanel.setLayout(new BoxLayout(eventListPanel, BoxLayout.Y_AXIS));
        eventDetailsPanel.setLayout(new BorderLayout());

        // Create the sign out button
        signOutButton = new JButton("Sign Out");
        signOutButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               signedOut();
           }
        });
        signOutButton.setVisible(false);
        signInPanel.add(signOutButton);
        
        // create the sign in button
        signInButton = new JButton("Sign In");
        signInButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               signInPrompt(false);
           }
        });
        signInPanel.add(signInButton);
        
        // create the register button
        registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               signInPrompt(true);
           }
        });
        signInPanel.add(registerButton);
        
        // creare a button for each of the events in the system
        for(Event event : this.ticketingSystem.getEvents()) {
            JButton eventButton = new JButton(event.name);
            eventButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            eventButton.setActionCommand(event.getIdString());
            eventButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    setSelectedEvent(e.getActionCommand());
                }
            });
            eventListPanel.add(eventButton);
        }
        
        // create a blank text area for details until an event is selected
        JTextArea signInText = new JTextArea("");
        eventDetailsPanel.add(signInText);
        
        // draw
        frame.add(signInPanel, BorderLayout.PAGE_START);
        frame.add(eventListPanel, BorderLayout.LINE_START);
        frame.add(eventDetailsPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
    
    /**
    * Displays the sign in / register user modal
    */
    private void signInPrompt(boolean newUser) {
        // create the input fields
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        Object[] inputFields = {
                "Username:", usernameField,
                "Password:", passwordField
        };
        
        // set up the options and show the modal
        int option = JOptionPane.showOptionDialog(null, inputFields, "Login", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
        
        // attempt to sign in the user
        if (option == JOptionPane.OK_OPTION) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            if (newUser) {
                try {
                    this.ticketingSystem.createUser(username, password);
                    signedIn();
                } catch(Exception e) {
                    System.out.println("Error: " + e);
                    signedOut();
                }
                
            } else {
                try {
                    this.ticketingSystem.signIn(username, password);
                    signedIn();
                } catch(Exception e) {
                    System.out.println("Error: " + e);
                    signedOut();
                }
            }
            
        } else {
            System.out.println("User cancelled login");
        }
    }
    
    /**
    * Changes the state of UI components based on authentication
    */
    private void signedOut() {
        this.ticketingSystem.signOut();
        this.signInButton.setVisible(true);
        this.registerButton.setVisible(true);
        this.signOutButton.setVisible(false);
        this.signedIn = false;
    }
    
    /**
    * Changes the state of the UI components based on authentication
    */
    private void signedIn() {
        this.signInButton.setVisible(false);
        this.registerButton.setVisible(false);
        this.signOutButton.setVisible(true);
        this.signedIn = true;
    }
    
    /**
    * Updates the UI to reflect the selected event
    */
    private void setSelectedEvent(String eventId) {    
        // tear down the existing details pane (Probably a more efficient way of doing this!)
        Container parent = this.eventDetailsPanel.getParent();
        parent.remove(this.eventDetailsPanel);
        
        // fetch the stored event
        Event event = this.ticketingSystem.getEvent(Integer.parseInt(eventId));
        this.eventDetailsPanel = new JPanel();
        this.eventDetailsPanel.setLayout(new BorderLayout(15, 5));
        
        // create the description text area
        JTextArea eventDescription = new JTextArea(event.description);
        eventDescription.setEditable(false);
        eventDescription.setLineWrap(true);
        eventDescription.setWrapStyleWord(true);
        this.eventDetailsPanel.add(eventDescription, BorderLayout.CENTER);
        
        // create the details panel
        JPanel showDetails = new JPanel();
        showDetails.setLayout(new BoxLayout(showDetails, BoxLayout.Y_AXIS));
        JLabel eventName = new JLabel(event.name);
        eventName.setAlignmentX(Component.LEFT_ALIGNMENT);
        showDetails.add(eventName);
        
        // add the show details to the details panel
        for(Show show : event.getShows()) {
            JLabel divider = new JLabel("-------");
            JLabel showName = new JLabel(show.name);
            JLabel startTime = new JLabel("Start: " + show.startTime);
            JLabel endTime = new JLabel("End: " + show.endTime);
            JLabel maxSeats = new JLabel("Seats: " + Integer.toString(show.maximumSeats));
            showDetails.add(Box.createRigidArea(new Dimension(0,10)));
            showDetails.add(showName);
            showDetails.add(divider);
            showDetails.add(startTime);
            showDetails.add(endTime);
            showDetails.add(maxSeats);
        }
        this.eventDetailsPanel.add(showDetails, BorderLayout.LINE_START);
        
        // create the seat options buttons
        JPanel selectSeatsPanel = new JPanel();
        JLabel seatLabel = new JLabel("Select Seats");
        JButton suggestSeatsButton = new JButton("Auto");
        suggestSeatsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectSeats();
            }
        });
        JButton selectSeatsButton = new JButton("Manual");
        selectSeatsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectSeats();
            }
        });
        
        selectSeatsPanel.add(seatLabel);
        selectSeatsPanel.add(suggestSeatsButton);
        selectSeatsPanel.add(selectSeatsButton);
        
        
        this.eventDetailsPanel.add(selectSeatsPanel, BorderLayout.PAGE_END);
        
        // add back to the parent and force redraw
        parent.add(this.eventDetailsPanel);
        parent.add(eventDetailsPanel, BorderLayout.CENTER);
        parent.revalidate();
        parent.repaint();
    }
    
    /**
    * Displays the seat selection modal
    */
    private void selectSeats() {
        
        if(this.signedIn) {
            JOptionPane.showMessageDialog(frame, 
                "You've reached the end of this prototype.", 
                "Congratulations", 
                JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(frame,
                "You must be signed in to book seats",
                "Authentication Error",
                JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
    
}
