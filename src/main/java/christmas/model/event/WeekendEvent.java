package christmas.model.event;

import christmas.model.EventPolicy;
import christmas.model.EventType;
import christmas.model.Reservation;

public class WeekendEvent implements EventPolicy {
    private final Reservation reservation;
    private final EventType eventType = EventType.WEEKEND;

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

    @Override
    public boolean isGiveaway() {
        return false;
    }

    @Override
    public EventType getEventType() {
        return eventType;
    }
}
