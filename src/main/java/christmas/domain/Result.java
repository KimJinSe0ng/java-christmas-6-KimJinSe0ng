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
    }

    private void showResult() {
        calculateTotalBeforeDiscount(); // 할인 전 총주문 금액
        calculateServiceMenu();
        calculateBenefit();
        calculateWeekday();
        calculateWeekend();
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

    public void calculateServiceMenu() {
        if (totalBeforeDiscount >= 120000) {
            serviceMenu = 1;
            System.out.println("<증정 메뉴>");
            System.out.println("샴페인 1개");
            System.out.println();
        } else {
            System.out.println("없음");
        }
    }

    public void calculateBenefit() {
        if (date <= 25) {
            dDayDiscount = 900 + (date * 100);
        }
        if (dDayDiscount == 0) {
            System.out.println("<혜택 내역>");
            System.out.println("없음");
        } else {
            System.out.println("크리스마스 디데이 할인: -" + dDayDiscount + "원");
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
            System.out.println("평일 할인: -" + weekdayDiscount + "원");
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
            System.out.println("주말 할인: -" + weekendDiscount + "원");
        }
    }
}
