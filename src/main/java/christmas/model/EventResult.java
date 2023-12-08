package christmas.model;

import christmas.model.event.ChristmasDdayEvent;
import christmas.model.event.GiveawayEvent;
import christmas.model.event.SpecialEvent;
import christmas.model.event.WeekdayEvent;
import christmas.model.event.WeekendEvent;
import java.util.Collections;
import java.util.List;

public class EventResult {

    private final List<EventPolicy> events;

    public EventResult(List<EventPolicy> events) {
        this.events = events;
    }

    public static EventResult of(Reservation reservation) {

        return new EventResult(
                List.of(new ChristmasDdayEvent(reservation), new GiveawayEvent(reservation),
                        new SpecialEvent(reservation), new WeekdayEvent(reservation),
                        new WeekendEvent(reservation)));
    }

    public List<EventPolicy> getEvents() {
        return Collections.unmodifiableList(events);
    }

    public int calculateTotalBenefitAmount() {
        return events.stream().mapToInt(event -> event.calculateDiscount()).sum();
    }


}
