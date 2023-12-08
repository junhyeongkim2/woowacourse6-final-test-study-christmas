package christmas.model.event;

import christmas.model.EventPolicy;
import christmas.model.Reservation;

public class WeekdayEvent implements EventPolicy {
    private final Reservation reservation;

    public WeekdayEvent(Reservation reservation) {
        this.reservation = reservation;
    }

    @Override
    public boolean isSatisfy(Reservation reservation) {
        return (reservation.isVisitDaySatisfyWeekday()&& reservation.isSatisfyTotalOrderAmount());
    }

    @Override
    public int calculateDiscount() {
        if (isSatisfy(reservation)) {
            return -(reservation.calculateDessertMenuCount() * 2023);
        }
        return 0;
    }
}
