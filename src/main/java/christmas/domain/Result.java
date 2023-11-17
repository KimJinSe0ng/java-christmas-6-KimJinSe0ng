package christmas.domain;

import static christmas.domain.DiscountType.*;

import java.util.Map;

public class Result {

    private int totalBeforeDiscount;
    private int serviceMenu;
    private int dDayDiscount;
    private int weekdayDiscount;
    private int weekendDiscount;
    private int specialDiscount;
    private int totalBenefit;
    private int totalAfterBenefit;
    private String badge = EventBadge.NONE.getDescription();

    private Map<Menu, Integer> orderedItems;
    private int date;

    private Result(Map<Menu, Integer> orderedItems, int date) {
        this.orderedItems = orderedItems;
        this.date = date;
        calculateTotalBeforeDiscount(); // 할인 전 총주문 금액
        checkEventExecutionConditions();
        calculateETCEvents();
    }

    private void calculateETCEvents() {
        calculateTotalAfterBenefit();
        calculateEventBadge();
    }

    private void checkEventExecutionConditions() {
        if (totalBeforeDiscount >= MIN_EVENT_CONDITION.getType()) {
            calculateAllEvents();
        }
    }

    private void calculateAllEvents() {
        calculateServiceMenu(); // 증정메뉴
        calculateBenefit();
        calculateWeekday();
        calculateWeekend();
        calculateSpecialDay();
        calculateAllBenefit();
    }

    public static Result from(Map<Menu, Integer> orderedItems, int date) {
        return new Result(orderedItems, date);
    }

    public void calculateTotalBeforeDiscount() {
        for (Map.Entry<Menu, Integer> entry : orderedItems.entrySet()) {
            Menu menu = entry.getKey();
            int quantity = entry.getValue();
            int menuPrice = menu.getPrice();
            int subtotal = menuPrice * quantity;

            totalBeforeDiscount += subtotal;
        }
    }

    public void calculateServiceMenu() {
        if (totalBeforeDiscount >= CHAMPAGNE_CONDITION.getType()) {
            serviceMenu = SERVICE_MENU_CONDITION.getType();
        }
    }

    public void calculateBenefit() {
        if (date <= DDAY_CONDITION.getType()) {
            dDayDiscount = BASE_AMOUNT.getType() + (date * DAY_BONUS.getType());
        }
    }

    public void calculateWeekday() {
        if (Calendar.isWeekday(date)) {
            int totalDessertCount = INIT_COUNT.getType(); // 디저트 카테고리의 총 개수

            for (Map.Entry<Menu, Integer> entry : orderedItems.entrySet()) {
                Menu menu = entry.getKey();
                int quantity = entry.getValue();

                // 디저트 카테고리인 경우 개수 합산
                if (menu.isDessert()) {
                    totalDessertCount += quantity;
                }
            }
            weekdayDiscount = totalDessertCount * SPECIALDAY_CONDITION.getType();
        }
    }

    public void calculateWeekend() {
        if (Calendar.isWeekend(date)) {
            int totalMainCount = INIT_COUNT.getType();

            for (Map.Entry<Menu, Integer> entry : orderedItems.entrySet()) {
                Menu menu = entry.getKey();
                int quantity = entry.getValue();

                // 메인 요리인 경우 개수 합산
                if (menu.isMain()) {
                    totalMainCount += quantity;
                }
            }
            weekendDiscount = totalMainCount * SPECIALDAY_CONDITION.getType();
        }
    }

    public void calculateSpecialDay() {
        if (Calendar.isSpecialDay(date)) {
            specialDiscount = SPECIAL_DISCOUNT.getType();
        }
    }

    public void calculateAllBenefit() {
        totalBenefit = dDayDiscount + weekdayDiscount + weekendDiscount + specialDiscount + (serviceMenu * CHAMPAGNE.getType());
    }

    public void calculateTotalAfterBenefit() {
        totalAfterBenefit = totalBeforeDiscount - (totalBenefit - (serviceMenu * CHAMPAGNE.getType()));
    }

    public void calculateEventBadge() {
        EventBadge badge = EventBadge.getBadge(totalBenefit);
        if (badge != null) {
            this.badge = badge.getDescription();
        }
    }

    public int getTotalBeforeDiscount() {
        return totalBeforeDiscount;
    }

    public int getServiceMenu() {
        return serviceMenu;
    }

    public int getdDayDiscount() {
        return dDayDiscount;
    }

    public int getWeekdayDiscount() {
        return weekdayDiscount;
    }

    public int getWeekendDiscount() {
        return weekendDiscount;
    }

    public int getSpecialDiscount() {
        return specialDiscount;
    }

    public int getTotalBenefit() {
        return totalBenefit;
    }

    public int getTotalAfterBenefit() {
        return totalAfterBenefit;
    }

    public String getBadge() {
        return badge;
    }

    public int getDate() {
        return date;
    }
}
