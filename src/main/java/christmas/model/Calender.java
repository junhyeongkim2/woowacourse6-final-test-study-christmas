package christmas.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class Calender {

    private final List<Integer> SPECIAL_DAYS = List.of(3, 10, 17, 24, 25, 31);
    private final int CURRENT_YEAR = 2023;
    private final int CURRENT_MONTH = 12;
    private final int START_DAY = 1;
    private final int END_DAY = 25;

    private final LocalDate calender;
    private final DayOfWeek dayOfWeek;


    public Calender(int visitDay) {
        calender = LocalDate.of(CURRENT_YEAR, CURRENT_MONTH, visitDay);
        dayOfWeek = calender.getDayOfWeek();
    }

    public boolean isChristmasDdayEvent() {
        if (calender.getDayOfMonth() >= START_DAY && calender.getDayOfMonth() <= END_DAY) {
            return true;
        }
        return false;
    }

    public boolean isWeekend() {
        return (dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY);
    }

    public boolean isWeekday() {
        return (dayOfWeek != DayOfWeek.FRIDAY && dayOfWeek != DayOfWeek.SATURDAY);
    }

    public boolean isSpecialDay() {
        if (SPECIAL_DAYS.contains(calender.getDayOfMonth())) {
            return true;
        }
        return false;
    }


    public int getDayOfMonth() {
        return calender.getDayOfMonth();
    }
}
