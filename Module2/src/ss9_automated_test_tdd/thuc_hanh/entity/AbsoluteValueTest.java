package ss9_automated_test_tdd.thuc_hanh.entity;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AbsoluteValueTest {
    private static int getResult(int number) {
        return AbsoluteValue.returnAbsoluteValue(number);
    }
    @Test
    @DisplayName("Testing absolute of 0 is 0")
    public void testAbsolute0() {
        int number = 0;
        int expected = 0;
        int result = getResult(number);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing absolute of 1 is 1")
    public void testAbsolute1() {
        int number = 1;
        int expected = 1;
        int result = getResult(number);
        assertEquals(expected, result);
    }
    @Test
    @DisplayName("Testing absolute of -1 is 1")
    public void testAbsoluteNegative1() {
        int number = -1;
        int expected = 1;
        int result = getResult(number);
        assertEquals(expected, result);
    }
    @Test
    @DisplayName("Testing absolute of Minvalue is Maxvalue")
    public void testAbsoluteMinvalue() {
        int number = Integer.MIN_VALUE;
        int expected = Integer.MAX_VALUE;
        int result = getResult(number);
    }
}
