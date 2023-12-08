package christmas.controller;

import christmas.model.Calender;
import christmas.model.EventResult;
import christmas.model.Reservation;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventPlannerController {

    public void start() {
        OutputView.printPlannerStartMessage();
        int visitDay = InputView.readVisitDay();
        String menuInput = InputView.readMenus();
        Reservation reservation = new Reservation(menuInput, new Calender(visitDay));
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
