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
        return false;
    }

    @Override
    public int calculateDiscount() {
        return 0;
    }
}
