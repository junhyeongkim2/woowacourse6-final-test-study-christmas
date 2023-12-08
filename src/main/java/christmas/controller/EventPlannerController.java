package christmas.controller;

import christmas.model.EventResult;
import christmas.model.Reservation;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventPlannerController {

    public void start() {
        OutputView.printPlannerStartMessage();
        int visitDay = InputView.readVisitDay();
        String menuInput = InputView.readMenus();
        Reservation reservation = new Reservation(visitDay, menuInput);
        OutputView.printVisitDayMessage(reservation);
        OutputView.printMenus(reservation);
        OutputView.printTotalOrderAmount(reservation);
        OutputView.printGiveaway(reservation);
        EventResult eventResult = EventResult.of(reservation);
        OutputView.printEventResult(eventResult);
        OutputView.printTotalBenefitAmount(eventResult);
        OutputView.printExpectedPaymentAmount(
                eventResult.calculateExpectedPaymentAmount(reservation.calculateTotalOrderAmount()));
        OutputView.printBadge(eventResult);
    }

}
