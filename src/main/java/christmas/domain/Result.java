package christmas.domain;

import christmas.view.OutputView;
import christmas.view.messages.PrintMessage;
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

    private Map<Menu, Integer> orderedItems;
    private int date;

    private Result(Map<Menu, Integer> orderedItems, int date) {
        this.orderedItems = orderedItems;
        this.date = date;
        showResult();
//        applyDiscountAndEvent();
    }

    private void showResult() {
        calculateTotalBeforeDiscount(); // 할인 전 총주문 금액
    }

    public static Result from(Map<Menu, Integer> orderedItems, int date) {
        return new Result(orderedItems, date);
    }

    public void calculateTotalBeforeDiscount() {
        for (Map.Entry<Menu, Integer> entry : orderedItems.entrySet()) {
            Menu menu = entry.getKey();
            int quantity = entry.getValue();

            // 각 메뉴의 가격과 수량을 이용하여 총 주문 금액 계산
            int menuPrice = menu.getPrice();
            int subtotal = menuPrice * quantity;

//            System.out.println(menu + "" + quantity + ", 가격: " + menuPrice + "원, 소계: " + subtotal + "원");

            // 총 주문 금액 누적
            totalBeforeDiscount += subtotal;
        }
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(totalBeforeDiscount + "원");
        System.out.println();
    }

}
