package christmas.domain;

import java.util.Map;

public class Result {

    private int totalBeforeDiscount;
    private int serviceMenu;
    private int dDayDiscount;
    private int weekDayDiscount;
    private int weekendDiscount;
    private int specialDiscount;

    private Map<Menu, Integer> orderedItems;
    private int date;

    private Result(Map<Menu, Integer> orderedItems, int date) {
        this.orderedItems = orderedItems;
        this.date = date;
        calculateTotalBeforeDiscount();
        calculateServiceMenu();
    }

    public static Result from(Map<Menu, Integer> orderedItems, int date) {
        return new Result(orderedItems, date);
    }

    public void calculateTotalBeforeDiscount() {
        for (Map.Entry<Menu, Integer> entry : this.orderedItems.entrySet()) {
            Menu menu = entry.getKey();
            int quantity = entry.getValue();
            int menuPrice = menu.getPrice();
            int subtotal = menuPrice * quantity;

            totalBeforeDiscount += subtotal;
        }

        System.out.println("총 주문 금액: " + totalBeforeDiscount + "원");
    }

    public void calculateServiceMenu() {
        if (totalBeforeDiscount >= 120000) {
            serviceMenu = 1;
        }
    }
}
