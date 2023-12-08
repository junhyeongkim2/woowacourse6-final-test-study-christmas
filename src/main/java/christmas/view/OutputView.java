package christmas.view;

import camp.nextstep.edu.missionutils.Console;
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


}
