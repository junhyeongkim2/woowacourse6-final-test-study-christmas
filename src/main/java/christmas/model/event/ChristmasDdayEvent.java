package christmas.model.event;

import christmas.model.EventPolicy;
import christmas.model.EventType;
import christmas.model.Reservation;

public class ChristmasDdayEvent implements EventPolicy {

    private final int STANDARD_VISIT_DAY_SETTING_VALUE = 1;
    private final int BASIC_DDAY_EVENT_DISCOUNT = 1000;

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
            return -((reservation.getVisitDay() - STANDARD_VISIT_DAY_SETTING_VALUE) *  EventType.CHRISTMASDDAY.getDiscountAmount() + BASIC_DDAY_EVENT_DISCOUNT);
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
