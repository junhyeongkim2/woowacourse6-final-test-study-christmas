package christmas.model;

public enum EventType {

    CHRISTMASDDAY("크리스마스 디데이 할인", 100),
    WEEKDAY("평일 할인", 2023),
    WEEKEND("주말 할인", 2023),
    SPECIAL("특별 할인", 1000),
    GIVEAWAY("증정 이벤트", Menu.샴페인.getPrice());

    private String name;
    private int discountAmount;

    EventType(String name, int discountAmount) {
        this.name = name;
        this.discountAmount = discountAmount;
    }

    public String getName() {
        return name;
    }
}
