package christmas.domain;

public enum DiscountType {
    MIN_EVENT_CONDITION(10000),
    CHAMPAGNE_CONDITION(120000),
    CHAMPAGNE(25000),
    SERVICE_MENU_CONDITION(1),
    DDAY_CONDITION(25),
    BASE_AMOUNT(900),
    DAY_BONUS(100),
    SPECIALDAY_CONDITION(2023),
    INIT_COUNT(0),
    SPECIAL_DISCOUNT(1000);

    private final int type;

    DiscountType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
