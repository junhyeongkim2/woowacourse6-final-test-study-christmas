package christmas.model.event;

import christmas.model.EventPolicy;
import christmas.model.Reservation;

public class WeekendEvent implements EventPolicy {
    private final Reservation reservation;

    public WeekendEvent(Reservation reservation) {
        this.reservation = reservation;
    }

    @Override
    public boolean isSatisfy(Reservation reservation) {
        return reservation.isVisitDaySatisfyWeekend() && reservation.isSatisfyTotalOrderAmount();
    }

    @Override
    public int calculateDiscount() {
        if (isSatisfy(reservation)) {
            return -(reservation.calculateMainMenuCount() * 2023);
        }
        return 0;
    }
}
