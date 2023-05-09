import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
 * The test class TicketingSystemTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TicketingSystemTest
{
    private TicketingSystem ticketingSystem;
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        ticketingSystem = new TicketingSystem();        
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
    
    @Test
    public void testSignInWithNoRegisteredUsers() {
        boolean thrown = false;
        try {
            ticketingSystem.signIn("bob", "test");
        } catch(Exception e) {
            System.out.println(e);
            thrown = true;
        }
        
        assertTrue(thrown);
    }

    
    @Test
    public void testSignInWithRegisteredUsers() {
        boolean thrown = false;
        ticketingSystem.createUser("bob", "test");
        try {
            ticketingSystem.signIn("bob", "test");
        } catch(Exception e) {
            System.out.println(e);
            thrown = true;
        }
        
        assertFalse(thrown);
        assertTrue(ticketingSystem.isSignedIn());
    }
    
    @Test
    public void testCreateUser() {
        boolean thrown = false;
        ticketingSystem.createUser("bob", "test");
        try {
            ticketingSystem.signIn("bob", "test");
        } catch(Exception e) {
            System.out.println(e);
            thrown = true;
        }
        assertFalse(thrown);
        assertTrue(ticketingSystem.isSignedIn());
    }
    
    @Test
    public void testSignOut() {
        
        try {
            ticketingSystem.signIn("bob", "test");
        } catch(Exception e) {
            System.out.println(e);
        }
        ticketingSystem.signOut();
        assertFalse(ticketingSystem.isSignedIn());
    }

    
    @Test
    public void testGetEvents() {
        ArrayList<Event> events = ticketingSystem.getEvents();
        assertEquals(7, events.size());
    }
    
    @Test
    public void testGetEvent() {
        Event event = ticketingSystem.getEvent(0);
        assertEquals("Lion King", event.name);
    }
    
}
