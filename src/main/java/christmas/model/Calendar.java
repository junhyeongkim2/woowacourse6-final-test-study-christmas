package christmas.model;

public interface Calendar {

    public boolean isWeekend();

    public boolean isWeekday();

    public boolean isSpecialDay();

    public int getDayOfMonth();

    boolean isChristmasDdayEvent();
}
