package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {


    private final static String ONE_MENU_PATTERN = "^[가-힣]+-\\d+$";
    private final static String TWO_OR_MORE_MENU_PATTERN = "([가-힣]+-\\d+)(?:,([가-힣]+-\\d+))*";
    private static final String READ_VISIT_DAY_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String READ_MENUS_MESSAGE = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";
    public static final String VISIT_DAY_ERROR_MESSAGE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    private static final String MENUS_ERROR_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    public static final int START_DAY = 1;
    public static final int END_DAY = 31;


    public static Integer readVisitDay() {
        System.out.println(READ_VISIT_DAY_MESSAGE);
        String input = Console.readLine();
        validateIsIntegerVisitDay(input);
        validateVisitDayRange(input);
        return Integer.parseInt(input);
    }

    public static String readMenus() {
        System.out.println(READ_MENUS_MESSAGE);
        String input = Console.readLine();
        validateMenuInputForm(input);
        return input;
    }

    public static void validateIsIntegerVisitDay(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(VISIT_DAY_ERROR_MESSAGE);
        }

    }

    public static void validateVisitDayRange(String input) {
        if (Integer.parseInt(input) < START_DAY || Integer.parseInt(input) > END_DAY) {
            throw new IllegalArgumentException(VISIT_DAY_ERROR_MESSAGE);
        }
    }

    private static void validateMenuInputForm(String menuInput) {

        Pattern oneMenuPattern = Pattern.compile(ONE_MENU_PATTERN);
        Pattern twoOrMoreMenuPatter = Pattern.compile(TWO_OR_MORE_MENU_PATTERN);

        Matcher oneMenuMatcher = oneMenuPattern.matcher(menuInput);
        Matcher twoOrMoreMenuMatcher = twoOrMoreMenuPatter.matcher(menuInput);

        if (!oneMenuMatcher.matches() && !twoOrMoreMenuMatcher.matches()) {
            throw new IllegalArgumentException(MENUS_ERROR_MESSAGE);
        }

    }


}
