package dramaplays;

import static org.junit.Assert.*;
import org.junit.Test;
import dramaplays.model.Invoice;
import dramaplays.model.Performance;
import dramaplays.model.Play;

import java.util.*;

public class FactorPrinterTest {

    @Test
    public void testSingleTragedyPerformance() {
        List<Performance> performances = Arrays.asList(new Performance("tree", 40));
        Invoice invoice = new Invoice("Ali", performances);
        Map<String, Play> plays = new HashMap<>();
        plays.put("tree", new Play("Tree", "tragedy"));

        FactorPrinter printer = new FactorPrinter();
        String result = printer.print(invoice, plays);

        String expected = "Factor for Ali\n" +
                "  Tree: $500.00 (40 seats)\n" +
                "Amount owed is $500.00\n" +
                "You earned 10 credits\n";

        assertEquals(expected, result);
    }

    @Test
    public void testSingleComedyPerformance() {
        List<Performance> performances = Arrays.asList(new Performance("hero", 25));
        Invoice invoice = new Invoice("Ali", performances);
        Map<String, Play> plays = new HashMap<>();
        plays.put("hero", new Play("Heroes in Battle", "comedy"));

        FactorPrinter printer = new FactorPrinter();
        String result = printer.print(invoice, plays);

        String expected = "Factor for Ali\n" +
                "  Heroes in Battle: $500.00 (25 seats)\n" +
                "Amount owed is $500.00\n" +
                "You earned 5 credits\n";

        assertEquals(expected, result);
    }

    @Test
    public void testEmptyPerformances() {
        List<Performance> performances = Collections.emptyList();
        Invoice invoice = new Invoice("Javad", performances);
        Map<String, Play> plays = new HashMap<>();

        FactorPrinter printer = new FactorPrinter();
        String result = printer.print(invoice, plays);

        String expected = "Factor for Javad\n" +
                "Amount owed is $0.00\n" +
                "You earned 0 credits\n";

        assertEquals(expected, result);
    }

    @Test(expected = Error.class)
    public void testUnknownPlayType() {
        List<Performance> performances = Arrays.asList(new Performance("Unknown", 20));
        Invoice invoice = new Invoice("Amin", performances);
        Map<String, Play> plays = new HashMap<>();
        plays.put("Unknown", new Play("Unknown Play", "Unknown"));

        FactorPrinter printer = new FactorPrinter();
        printer.print(invoice, plays);
    }

    @Test
    public void testMultiplePerformances() {
        List<Performance> performances = Arrays.asList(
                new Performance("tree", 55),
                new Performance("hero", 35),
                new Performance("people", 40)
        );
        Invoice invoice = new Invoice("Akbar", performances);
        Map<String, Play> plays = new HashMap<>();
        plays.put("tree", new Play("Tree", "tragedy"));
        plays.put("hero", new Play("Heroes in Battle", "comedy"));
        plays.put("people", new Play("People", "tragedy"));

        FactorPrinter printer = new FactorPrinter();
        String result = printer.print(invoice, plays);

        String expected = "Factor for Akbar\n" +
                "  Tree: $650.00 (55 seats)\n" +
                "  Heroes in Battle: $580.00 (35 seats)\n" +
                "  People: $500.00 (40 seats)\n" +
                "Amount owed is $1,730.00\n" +
                "You earned 47 credits\n";

        assertEquals(expected, result);
    }
}
