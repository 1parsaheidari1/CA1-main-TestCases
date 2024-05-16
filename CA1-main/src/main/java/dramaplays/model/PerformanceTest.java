package dramaplays.model;

import static org.junit.Assert.*;
import org.junit.Test;

public class PerformanceTest {

    @Test
    public void testConstructorInitialization() {
        Performance performance = new Performance("tree", 55);
        
        assertEquals("tree", performance.playID);
        assertEquals(55, performance.audience);
    }

    @Test
    public void testPlayIDField() {
        Performance performance = new Performance("Hero", 40);
        
        assertEquals("Hero", performance.playID);
    }

    @Test
    public void testAudienceField() {
        Performance performance = new Performance("people", 60);
        
        assertEquals(60, performance.audience);
    }
}
