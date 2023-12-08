package christmas.model.event;

import christmas.model.EventPolicy;
import christmas.model.EventType;
import christmas.model.Reservation;

public class SpecialEvent implements EventPolicy {
    private final Reservation reservation;
    private final EventType eventType = EventType.SPECIAL;
    public SpecialEvent(Reservation reservation) {
        this.reservation = reservation;
    }

    @Override
    public boolean isSatisfy(Reservation reservation) {
        return (reservation.isVisitDaySatisfySpecialDay()&& reservation.isSatisfyTotalOrderAmount());
    }

    @Override
    public int calculateDiscount() {
        if (isSatisfy(reservation)) {
            return -1000;
        }
        return 0;
    }

    @Override
    public boolean isGiveaway() {
        return false;
    }

    @Override
    public EventType getEventType() {
        return eventType;
    }
}
