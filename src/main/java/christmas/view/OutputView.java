package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.model.EventResult;
import christmas.model.Menu;
import christmas.model.Reservation;

public class OutputView {
    public static void printPlannerStartMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public static void printVisitDayMessage(Reservation reservation) {
        System.out.printf("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!", reservation.getVisitDay());
    }

    public static void printMenus(Reservation reservation) {
        System.out.println("<주문 메뉴>");
        System.out.println(reservation.getMenusAndCount());
    }

    public static void printTotalOrderAmount(Reservation reservation) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(reservation.calculateTotalOrderAmount());
    }

    public static void printGiveaway(Reservation reservation) {
        System.out.println("<증정 메뉴>");
        if (reservation.isGiveaway()) {
            System.out.printf("%s 1개\n", Menu.샴페인);
        }
        if (!reservation.isGiveaway()) {
            System.out.println("없음");
        }
    }

    public static void printEventResult(EventResult eventResult) {
        System.out.println("<혜택 내역>");
        System.out.println(eventResult.toString());
    }

    public static void printTotalBenefitAmount(EventResult eventResult) {
        System.out.println("<총혜택 금액>");
        System.out.println(eventResult.calculateTotalBenefitAmount());
    }

    public static void printExpectedPaymentAmount(int expectedPaymentAmount) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(expectedPaymentAmount);
    }

    public static void printBadge(EventResult eventResult) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(eventResult.calculateBadge());
    }

}
