package Euros;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EuroTest {
    @Test
    public void testToString(){
        assertEquals("EUR 2.00", new Euro(2).toString());
        assertEquals("EUR 7.50", new Euro(7.5).toString());
    }

    @Test
    public void testEquality(){
        Euro sevenFifty = new Euro(7.50);
        Euro sevenFiftyToo = new Euro(7.50);
        assertTrue(sevenFifty.equals(sevenFiftyToo));
    }

    @Test
    public void testInequality(){
        Euro sevenFifty = new Euro(7.50);
        Euro notSevenFifty = new Euro(2.99);
        assertFalse(sevenFifty.equals(notSevenFifty));
    }

    @Test
    public void testSubtraction(){
        assertEquals(new Euro(1), new Euro(6).minus(new Euro(5)));
        assertEquals(new Euro(0.5), new Euro(1).minus(new Euro(0.5)));
    }

    @Test
    public void numericSafety() {
        assertEquals(new Euro(0.61), new Euro(1.03).minus(new Euro(0.42)));
    }

    @Test
    public void testNotSameObject() {
        Euro sevenFifty = new Euro(7.50);
        Object a = new Object();
        assertFalse((sevenFifty.equals(a)));
    }
}
