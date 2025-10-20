package ss9_automated_test_tdd.bai_tap.entity;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class NextDayCalculatorTest {
    @Test
    @DisplayName("Testing next day of 1/1/2018")
    public void testNextDay1_1_2018() {
        LocalDate date = LocalDate.of(2018, 1, 1);
        LocalDate expected = LocalDate.of(2018, 1, 2);
        assertEquals(expected,new NextDayCalculator().getNextDay(date));
    }
    @Test
    @DisplayName("Testing next day of 1/31/2018")
    public void testNextDay1_31_2018() {
        LocalDate date = LocalDate.of(2018, 1, 31);
        LocalDate expected = LocalDate.of(2018, 2, 1);
        assertEquals(expected,new NextDayCalculator().getNextDay(date));
    }
    @Test
    @DisplayName("Testing next day of 4/30/2018")
    public void testNextDay4_30_2018() {
        LocalDate date = LocalDate.of(2018, 4, 30);
        LocalDate expected = LocalDate.of(2018, 5, 1);
        assertEquals(expected,new NextDayCalculator().getNextDay(date));
    }
    @Test
    @DisplayName("Testing next day of 2/28/2018")
    public void testNextDay2_28_2018() {
        LocalDate date = LocalDate.of(2018, 2, 28);
        LocalDate expected = LocalDate.of(2018, 3, 1);
        assertEquals(expected,new NextDayCalculator().getNextDay(date));
    }
    @Test
    @DisplayName("Testing next day of 2/29/2020")
    public void testNextDay2_29_2020() {
        LocalDate date = LocalDate.of(2020, 2, 29);
        LocalDate expected = LocalDate.of(2020, 3, 1);
        assertEquals(expected,new NextDayCalculator().getNextDay(date));
    }
    @Test
    @DisplayName("Testing next day of 12/31/2018")
    public void testNextDay12_31_2018() {
        LocalDate date = LocalDate.of(2018, 12, 31);
        LocalDate expected = LocalDate.of(2019, 1, 1);
        assertEquals(expected,new NextDayCalculator().getNextDay(date));
    }
}
