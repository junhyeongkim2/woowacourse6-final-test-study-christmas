package christmas.model.event;

import christmas.model.EventPolicy;
import christmas.model.EventType;
import christmas.model.Reservation;

public class ChristmasDdayEvent implements EventPolicy {

    private final Reservation reservation;
    private final EventType eventType = EventType.CHRISTMASDDAY;

    public ChristmasDdayEvent(Reservation reservation) {
        this.reservation = reservation;
    }

    @Override
    public boolean isSatisfy(Reservation reservation) {
        return (reservation.isVisitDaySatisfyChristmasDdayEvent() && reservation.isSatisfyTotalOrderAmount());
    }


    @Override
    public int calculateDiscount() {
        if (isSatisfy(reservation)) {
            return -((reservation.getVisitDay() - 1) *  EventType.CHRISTMASDDAY.getDiscountAmount() + 1000);
        }
        return 0;
    }

    @Override
    public boolean isGiveaway() {
        return false;
    }

    public EventType getEventType() {
        return eventType;
    }
}
