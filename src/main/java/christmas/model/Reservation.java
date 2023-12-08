package christmas.model;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Reservation {

    private final static String MENU_SPLIT_REGEX = "(\\p{IsHangul}+)-(\\d+)";
    private final static int MENU_NAME = 1;
    private final static int MENU_COUNT = 2;
    private final static String BLANK = " ";
    private final static String QUANITY = "개";
    private final static String LINE = "\n";
    private final static int STANDARD_TOTAL_ORDER_AMOUNT = 120000;
    private final static int MAX_ORDER_COUNT = 20;
    private static final String MENUS_ERROR_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    private final Map<Menu, Integer> menus;
    private final Calendar christmasCalendar;

    public Reservation(String menuInput, Calendar christmasCalendar) {
        Map<Menu, Integer> menus = createMenus(menuInput);
        validateIsOverTwentyMenu(menus);
        validateIsOnlyDrink(menus);
        this.menus = menus;
        this.christmasCalendar = christmasCalendar;
    }

    public Map<Menu, Integer> createMenus(String menuInput) {
        Map<Menu, Integer> menus = new EnumMap<Menu, Integer>(Menu.class);
        Pattern twoOrMoreMenuPattern = Pattern.compile(MENU_SPLIT_REGEX);
        Matcher twoOrMoreMenuMatcher = twoOrMoreMenuPattern.matcher(menuInput);
        while (twoOrMoreMenuMatcher.find()) {
            String menuName = twoOrMoreMenuMatcher.group(MENU_NAME);
            int menuCount = Integer.parseInt(twoOrMoreMenuMatcher.group(MENU_COUNT));
            validateIsContainMenu(menuName);
            validateDuplicateMenu(menuName, menus);
            validateIsUnderOneMenu(menuCount);
            menus.put(Menu.valueOf(menuName), menuCount);
        }
        return menus;
    }

    public int getVisitDay() {
        return christmasCalendar.getDayOfMonth();
    }

    public String getMenusAndCount() {
        StringBuilder sb = new StringBuilder();
        menus.entrySet().stream().forEach(key -> sb.append(key.getKey() + BLANK + key.getValue() + QUANITY + LINE));
        return sb.toString();
    }


    public int calculateDessertMenuCount() {
        List<Menu> keys = menus.keySet().stream().collect(Collectors.toList());
        List<Menu> desserts = Arrays.stream(Menu.values()).filter(Menu::isDessert).collect(Collectors.toList());
        return keys.stream().filter(key -> desserts.contains(key)).mapToInt(key -> menus.get(key)).sum();
    }

    public boolean isVisitDaySatisfyChristmasDdayEvent() {
        return christmasCalendar.isChristmasDdayEvent();
    }

    public boolean isVisitDaySatisfyWeekday() {
        return christmasCalendar.isWeekday();
    }

    public boolean isVisitDaySatisfyWeekend() {
        return christmasCalendar.isWeekend();
    }

    public boolean isVisitDaySatisfySpecialDay() {
        return christmasCalendar.isSpecialDay();
    }


    public int calculateMainMenuCount() {
        List<Menu> keys = menus.keySet().stream().collect(Collectors.toList());
        List<Menu> mains = Arrays.stream(Menu.values()).filter(Menu::isMain).collect(Collectors.toList());
        return keys.stream().filter(key -> mains.contains(key)).mapToInt(key -> menus.get(key)).sum();
    }


    public boolean isGiveaway() {
        if (calculateTotalOrderAmount() >= STANDARD_TOTAL_ORDER_AMOUNT) {
            return true;
        }
        return false;
    }

    public int calculateTotalOrderAmount() {
        return menus.entrySet().stream()
                .mapToInt(key -> Menu.valueOf(String.valueOf(key.getKey())).getPrice() * key.getValue())
                .sum();
    }


    public boolean isSatisfyTotalOrderAmount() {
        if (calculateTotalOrderAmount() >= 10000) {
            return true;
        }
        return false;
    }

    private Map<Menu, Integer> validateIsOnlyDrink(Map<Menu, Integer> menus) {
        if (menus.keySet().stream().allMatch(key -> key.isDrink())) {
            throw new IllegalArgumentException(MENUS_ERROR_MESSAGE);
        }
        return menus;
    }

    public void validateIsOverTwentyMenu(Map<Menu, Integer> menus) {
        if (menus.entrySet().stream().mapToInt(key -> key.getValue()).sum() > MAX_ORDER_COUNT) {
            throw new IllegalArgumentException(MENUS_ERROR_MESSAGE);
        }
    }

    public void validateIsContainMenu(String menuName) {
        if (!Menu.isContain(menuName)) {
            throw new IllegalArgumentException(MENUS_ERROR_MESSAGE);
        }
    }

    public void validateIsUnderOneMenu(int menuCount) {
        if (menuCount < 1) {
            throw new IllegalArgumentException(MENUS_ERROR_MESSAGE);
        }
    }

    public void validateDuplicateMenu(String menuName, Map<Menu, Integer> menus) {
        if (menus.containsKey(Menu.valueOf(menuName))) {
            throw new IllegalArgumentException(MENUS_ERROR_MESSAGE);
        }
    }



}
