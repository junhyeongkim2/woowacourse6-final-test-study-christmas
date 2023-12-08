package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import net.bytebuddy.pool.TypePool.Resolution.Illegal;

public class InputView {

    public static Integer readVisitDay() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String input = Console.readLine();
        validateVisitDayRange(input);
        return Integer.parseInt(input);
    }

    public static String readMenus() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        String input = Console.readLine();
        return input;
    }

    public static void validateVisitDayRange(String input) {
        if (Integer.parseInt(input) < 1 || Integer.parseInt(input) > 31) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }


}
