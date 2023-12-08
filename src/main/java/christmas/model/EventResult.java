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


    public int calculateExpectedPaymentAmount(int totalOderAmount) {
        return totalOderAmount + events.stream().filter(event -> !event.isGiveaway())
                .mapToInt(event -> event.calculateDiscount()).sum();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (events.stream().mapToInt(event -> event.calculateDiscount()).sum() == 0) {
            return "없음\n";
        }
        events.stream().filter(event -> event.calculateDiscount() != 0)
                .forEach(event -> sb.append(event.getEventType().getName() + ": " + event.calculateDiscount() + "원\n"));
        return sb.toString();
    }

    public String calculateBadge() {
        return Badge.valueOf(calculateTotalBenefitAmount()).getName();
    }
}
