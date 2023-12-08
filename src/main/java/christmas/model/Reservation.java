package christmas.model;

import java.text.DateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;

public class Reservation {

    private final Map<Menu, Integer> menus;
    private final Calender calender;

    public Reservation(String menuInput, Calender calendar) {
        this.menus = validateIsOnlyDrink(createMenus(menuInput));
        this.calender = calendar;
    }

    public Map<Menu, Integer> createMenus(String menuInput) {
        Map<Menu, Integer> menus = new EnumMap<Menu, Integer>(Menu.class);
        Pattern twoOrMoreMenuPattern = Pattern.compile("(\\p{IsHangul}+)-(\\d+)");
        Matcher twoOrMoreMenuMatcher = twoOrMoreMenuPattern.matcher(menuInput);
        while (twoOrMoreMenuMatcher.find()) {
            String menuName = twoOrMoreMenuMatcher.group(1);
            int menuCount = Integer.parseInt(twoOrMoreMenuMatcher.group(2));
            menus.put(Menu.valueOf(menuName), menuCount);
        }
        return menus;
    }

    public int getVisitDay() {
        return calender.getDayOfMonth();
    }

    public String getMenusAndCount() {
        StringBuilder sb = new StringBuilder();
        menus.entrySet().stream().forEach(key -> sb.append(key.getKey() + " " + key.getValue() + "개\n"));
        return sb.toString();
    }


    public int calculateDessertMenuCount() {
        List<Menu> keys = menus.keySet().stream().collect(Collectors.toList());
        List<Menu> desserts = Arrays.stream(Menu.values()).filter(Menu::isDessert).collect(Collectors.toList());
        return keys.stream().filter(key -> desserts.contains(key)).mapToInt(key -> menus.get(key)).sum();
    }

    public boolean isVisitDaySatisfyChristmasDdayEvent() {
        return calender.isChristmasDdayEvent();
    }

    public boolean isVisitDaySatisfyWeekday() {
        return calender.isWeekday();
    }

    public boolean isVisitDaySatisfyWeekend() {
        return calender.isWeekend();
    }

    public boolean isVisitDaySatisfySpecialDay() {
        return calender.isSpecialDay();
    }


    public int calculateMainMenuCount() {
        List<Menu> keys = menus.keySet().stream().collect(Collectors.toList());
        List<Menu> mains = Arrays.stream(Menu.values()).filter(Menu::isMain).collect(Collectors.toList());
        return keys.stream().filter(key -> mains.contains(key)).mapToInt(key -> menus.get(key)).sum();
    }


    public boolean isGiveaway() {
        if (calculateTotalOrderAmount() >= 120000) {
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

    public Map<Menu,Integer> validateIsOnlyDrink(Map<Menu, Integer> menus) {
        if (menus.keySet().stream().allMatch(key -> key.isDrink())) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
        return menus;
    }
}
