package christmas.model.event;

import christmas.model.EventPolicy;
import christmas.model.Reservation;

public class SpecialEvent implements EventPolicy {
    private final Reservation reservation;

    public SpecialEvent(Reservation reservation) {
        this.reservation = reservation;
    }

    @Override
    public boolean isSatisfy(Reservation reservation) {
        return reservation.isVisitDaySatisfySpecialDay();
    }

    @Override
    public int calculateDiscount() {
        if (isSatisfy(reservation)) {
            return -1000;
        }
        return 0;
    }
}
