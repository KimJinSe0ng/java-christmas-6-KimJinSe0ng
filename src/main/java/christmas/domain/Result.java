package christmas.domain;

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
    private String badge;

    private Map<Menu, Integer> orderedItems;
    private int date;

    private Result(Map<Menu, Integer> orderedItems, int date) {
        this.orderedItems = orderedItems;
        this.date = date;
        calculateAllEvents();
    }

    private void calculateAllEvents() {
        calculateTotalBeforeDiscount(); // 할인 전 총주문 금액
        calculateServiceMenu(); // 증정메뉴
        calculateBenefit();
        calculateWeekday();
        calculateWeekend();
        calculateSpecialDay();
        calculateAllBenefit();
        calculateTotalAfterBenefit();
        calculateEventBadge();
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
        if (totalBeforeDiscount >= 120000) {
            serviceMenu = 1;
        }
    }

    public void calculateBenefit() {
        if (date <= 25) {
            dDayDiscount = 900 + (date * 100);
        }
    }

    public void calculateWeekday() {
        if (Calendar.isWeekday(date)) {
            int totalDessertCount = 0; // 디저트 카테고리의 총 개수

            for (Map.Entry<Menu, Integer> entry : orderedItems.entrySet()) {
                Menu menu = entry.getKey();
                int quantity = entry.getValue();

                // 디저트 카테고리인 경우 개수 합산
                if (menu.isDessert()) {
                    totalDessertCount += quantity;
                }
            }
            weekdayDiscount = totalDessertCount * 2023;
        }
    }

    public void calculateWeekend() {
        if (Calendar.isWeekend(date)) {
            int totalMainCount = 0;

            for (Map.Entry<Menu, Integer> entry : orderedItems.entrySet()) {
                Menu menu = entry.getKey();
                int quantity = entry.getValue();

                // 메인 요리인 경우 개수 합산
                if (menu.isMain()) {
                    totalMainCount += quantity;
                }
            }
            weekendDiscount = totalMainCount * 2023;
        }
    }

    public void calculateSpecialDay() {
        if (Calendar.isSpecialDay(date)) {
            specialDiscount = 1000;
        }
    }

    public void calculateAllBenefit() {
        totalBenefit = dDayDiscount + weekdayDiscount + weekendDiscount + specialDiscount + (serviceMenu * 25000);
    }

    public void calculateTotalAfterBenefit() {
        totalAfterBenefit = totalBeforeDiscount - (totalBenefit - (serviceMenu * 25000));
    }

    public void calculateEventBadge() {
        EventBadge badge = EventBadge.getBadge(totalBenefit);
        if (badge != null) {
            this.badge = badge.getDescription();
        }
        if (badge == null) {
            this.badge = "없음";
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
