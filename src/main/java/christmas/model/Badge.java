package christmas.model;

public enum Badge {
    NONE("없음", 0),
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000);

    private String name;
    private int condition;

    Badge(String name, int condition) {
        this.name = name;
        this.condition = condition;
    }

    public static Badge valueOf(int totalBenefitAmount) {
        if (totalBenefitAmount >= SANTA.condition) {
            return SANTA;
        }
        if (totalBenefitAmount >= TREE.condition) {
            return TREE;
        }
        if (totalBenefitAmount >= STAR.condition) {
            return STAR;
        }
        return NONE;
    }


}
