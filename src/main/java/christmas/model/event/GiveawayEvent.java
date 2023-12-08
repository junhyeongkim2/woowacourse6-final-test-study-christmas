package christmas.model.event;

import christmas.model.EventPolicy;
import christmas.model.EventType;
import christmas.model.Menu;
import christmas.model.Reservation;

public class GiveawayEvent implements EventPolicy {

    private final Reservation reservation;
    private final EventType eventType = EventType.GIVEAWAY;
    public GiveawayEvent(Reservation reservation) {
        this.reservation = reservation;
    }

    @Override
    public boolean isSatisfy(Reservation reservation) {
        return (reservation.isGiveaway() && reservation.isSatisfyTotalOrderAmount());
    }

    @Override
    public int calculateDiscount() {
        if (isSatisfy(reservation)) {
            return -Menu.샴페인.getPrice();
        }
        return 0;
    }

    @Override
    public boolean isGiveaway() {
        return true;
    }

    @Override
    public EventType getEventType() {
        return eventType;
    }
}
