/**
 * RomanToDecimalTest is a test program that tests RomanToDecimal.java.
 * It includes logically incorrect entries, invalid entries, and valid entries.
 * @version Monday, September 27, 2021
 * @author haleyfogg
 */
import static org.junit.Assert.*;

public class RomanToDecimalTest {

    @org.junit.Test
    public void romanToDecimal() {
        assertEquals(RomanToDecimal.romanToDecimal("XI"), 11);
        assertEquals(RomanToDecimal.romanToDecimal("IXIX"), -2);
        assertEquals(RomanToDecimal.romanToDecimal("ur mom"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("CM"), 900);
        assertEquals(RomanToDecimal.romanToDecimal("XIII"), 13);
        assertEquals(RomanToDecimal.romanToDecimal("ABC"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("hello"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("ixixix"), -2);
        assertEquals(RomanToDecimal.romanToDecimal("iv"), 4);
        assertEquals(RomanToDecimal.romanToDecimal("xiv"), 14);
        assertEquals(RomanToDecimal.romanToDecimal("ixiv"), -2);
        assertEquals(RomanToDecimal.romanToDecimal("cd"), 400);
        assertEquals(RomanToDecimal.romanToDecimal("xxxxi"), -2);
        assertEquals(RomanToDecimal.romanToDecimal("xiva"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("MMMCD"), 3400);
        assertEquals(RomanToDecimal.romanToDecimal("12"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("IX!"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("IV, IX"), -1);
        assertNotEquals(RomanToDecimal.romanToDecimal("Joe"), 20);
        assertNotEquals(RomanToDecimal.romanToDecimal("MMMCD"), -1);
    }
}