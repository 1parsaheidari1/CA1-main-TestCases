package dramaplays.model;


import static org.junit.Assert.*;
import org.junit.Test;

public class PlayTest {

    @Test
    public void testConstructorInitialization() {
        Play play = new Play("Hero", "Ghahremani");
        
        assertEquals("Hero", play.name);
        assertEquals("Ghahremani", play.type);
    }

    @Test
    public void testNameField() {
        Play play = new Play("tree", "Drama");
        
        assertEquals("tree", play.name);
    }

    @Test
    public void testTypeField() {
        Play play = new Play("Tehran", "Action");
        
        assertEquals("Action", play.type);
    }
}
