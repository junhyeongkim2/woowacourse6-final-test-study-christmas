package christmas.model;

import java.util.EnumMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reservation {

    private final int visitDay;
    private final Map<Menu, Integer> menus;

    public Reservation(int visitDay, String menuInput) {
        this.visitDay = visitDay;
        this.menus = createMenus(menuInput);

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
        return visitDay;
    }


    public boolean isVisitDaySatisfyChristmasDdayEvent() {
        if (visitDay >= 1 && visitDay <= 25) {
            return true;
        }
        return false;
    }
}
