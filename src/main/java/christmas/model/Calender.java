package christmas.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class Calender {

    private final LocalDate calender;
    private final DayOfWeek dayOfWeek;
    private final List<Integer> SPECIAL_DAYS = List.of(3, 10, 17, 24, 25, 31);


    public Calender(int visitDay) {
        calender = LocalDate.of(2023, 12, visitDay);
        dayOfWeek = calender.getDayOfWeek();
    }

    public boolean isChristmasDdayEvent() {
        if (calender.getDayOfMonth() >= 1 && calender.getDayOfMonth() <= 25) {
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
