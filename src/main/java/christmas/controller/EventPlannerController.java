package christmas.controller;

import christmas.model.ChristmasCalendar;
import christmas.model.EventResult;
import christmas.model.Reservation;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.function.Supplier;

public class EventPlannerController {

    public void start() {
        OutputView.printPlannerStartMessage();
        int visitDay = repeatUntilValid(() -> InputView.readVisitDay());
        Reservation reservation = repeatUntilValid(
                () -> new Reservation(InputView.readMenus(), new ChristmasCalendar(visitDay)));
        printReservation(reservation);
        EventResult eventResult = EventResult.of(reservation);
        printEventResult(reservation, eventResult);
    }

    private void printEventResult(Reservation reservation, EventResult eventResult) {
        OutputView.printEventResult(eventResult);
        OutputView.printTotalBenefitAmount(eventResult);
        OutputView.printExpectedPaymentAmount(
                eventResult.calculateExpectedPaymentAmount(reservation.calculateTotalOrderAmount()));
        OutputView.printBadge(eventResult);
    }

    private void printReservation(Reservation reservation) {
        OutputView.printVisitDayMessage(reservation);
        OutputView.printMenus(reservation);
        OutputView.printTotalOrderAmount(reservation);
        OutputView.printGiveaway(reservation);
    }

    private <T> T repeatUntilValid(Supplier<T> function) {
        try {
            return function.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return repeatUntilValid(function);
        }
    }


}
