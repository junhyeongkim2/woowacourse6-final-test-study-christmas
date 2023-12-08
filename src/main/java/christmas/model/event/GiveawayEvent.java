package christmas.model.event;

import christmas.model.EventPolicy;
import christmas.model.Menu;
import christmas.model.Reservation;

public class GiveawayEvent implements EventPolicy {

    private final Reservation reservation;

    public GiveawayEvent(Reservation reservation) {
        this.reservation = reservation;
    }

    @Override
    public boolean isSatisfy(Reservation reservation) {
        return reservation.isGiveaway();
    }

    @Override
    public int calculateDiscount() {
        return -Menu.샴페인.getPrice();
    }
}
