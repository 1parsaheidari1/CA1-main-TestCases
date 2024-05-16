package dramaplays.model;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

public class InvoiceTest {

    @Test
    public void testConstructorInitialization() {
        Performance performance1 = new Performance("tree", 55);
        Performance performance2 = new Performance("12-soldiers", 35);
        List<Performance> performances = Arrays.asList(performance1, performance2);
        
        Invoice invoice = new Invoice("Ali", performances);
        
        assertEquals("Ali", invoice.customer);
        assertEquals(performances, invoice.performances);
    }

    @Test
    public void testCustomerField() {
        Performance performance = new Performance("eyes", 40);
        List<Performance> performances = Arrays.asList(performance);
        
        Invoice invoice = new Invoice("Javad", performances);
        
        assertEquals("Javad", invoice.customer);
    }

    @Test
    public void testPerformancesField() {
        Performance performance1 = new Performance("hero", 60);
        Performance performance2 = new Performance("lion", 50);
        List<Performance> performances = Arrays.asList(performance1, performance2);
        
        Invoice invoice = new Invoice("Amin", performances);
        
        assertEquals(2, invoice.performances.size());
        assertEquals("hero", invoice.performances.get(0).playID);
        assertEquals(60, invoice.performances.get(0).audience);
        assertEquals("lion", invoice.performances.get(1).playID);
        assertEquals(50, invoice.performances.get(1).audience);
    }
}
