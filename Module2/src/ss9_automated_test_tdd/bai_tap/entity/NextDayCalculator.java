package ss9_automated_test_tdd.bai_tap.entity;

import java.time.LocalDate;

public class NextDayCalculator {

    public LocalDate getNextDay(LocalDate date) {
        return date.plusDays(1);
    }
}
