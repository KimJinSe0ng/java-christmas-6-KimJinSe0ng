package christmas.view;

import christmas.domain.Menu;
import christmas.domain.Order;
import christmas.domain.Result;
import christmas.view.messages.PrintMessage;
import java.util.Map;

public class OutputView {
    public static void println(Object data) {
        System.out.println(data);

    }
    public static void printMessage(final PrintMessage message) {
        System.out.println(message.getMessage());
    }

    public static void printOrder(Order order) {
        Map<Menu, Integer> orderedItems = order.getOrderedItems();
        printMessage(PrintMessage.OUTPUT_ORDER);
        for (Map.Entry<Menu, Integer> entry : orderedItems.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue() + PrintMessage.COUNT.getMessage());
        }
    }

    public static void printAllEvents(Result result) {
        printTotalBeforeDiscount(result);
        printServiceMenu(result);
        printBenefit(result);
        printWeekday(result);
        printWeekend(result);
        printSpecialDay(result);
        printAllBenefit(result);
        printTotalAfterBenefit(result);
        printEventBadge(result);
    }

    public static void printTotalBeforeDiscount(Result result) {
        System.out.println(PrintMessage.OUTPUT_TOTAL_BEFORE_DISCOUNT.getMessage());
        System.out.println(result.getTotalBeforeDiscount() + "" + PrintMessage.MONEY.getMessage() + "\n");
    }


    public static void printServiceMenu(Result result) {
        System.out.println(PrintMessage.OUTPUT_GIFT_MENU.getMessage());
        if (result.getServiceMenu() == 1) {
            System.out.println("샴페인 1개s" + "\n");
        }
    }

    public static void printBenefit(Result result) {
        System.out.println(PrintMessage.OUTPUT_BENEFIT.getMessage());
        if (result.getdDayDiscount() == 0) {
            System.out.println(PrintMessage.NONE.getMessage());
        }
        if (result.getdDayDiscount() != 0) {
            System.out.println("크리스마스 할인: -" + result.getdDayDiscount() + "" + PrintMessage.MONEY.getMessage());
        }
    }

    public static void printWeekday(Result result) {
        if (result.getWeekdayDiscount() != 0) {
            System.out.println("평일 할인: -" + result.getWeekdayDiscount() + "원");
        }
    }

    public static void printWeekend(Result result) {
        if (result.getWeekendDiscount() != 0) {
            System.out.println("주말 할인: -" + result.getWeekendDiscount() + "원");
        }
    }

    public static void printSpecialDay(Result result) {
        System.out.println("특별 할인: -" + result.getSpecialDiscount() + "원");
        if (result.getServiceMenu() == 1) {
            System.out.println("증정 이벤트: -" + 25000 + "원");
        }
    }

    public static void printAllBenefit(Result result) {
        System.out.println("\n" + "<총혜택 금액>");
        System.out.println("-" + result.getTotalBenefit() + "원" + "\n");
    }

    public static void printTotalAfterBenefit(Result result) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(result.getTotalAfterBenefit() + "원" + "\n");
    }

    public static void printEventBadge(Result result) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(result.getBadge());
    }
}
