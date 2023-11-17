package christmas.view;

import static christmas.view.messages.PrintMessage.*;

import christmas.domain.Menu;
import christmas.domain.Order;
import christmas.domain.Result;
import christmas.view.messages.PrintMessage;
import java.util.Map;

public class OutputView {
    private static final int TRUE = 1;
    private static final int FALSE = 0;
    private static final int CHAMPAGNE = 25000;
    public static void println(Object data) {
        System.out.println(data);

    }
    public static void printMessage(final PrintMessage message) {
        System.out.println(message.getMessage());
    }

    public static void printOrder(Order order) {
        Map<Menu, Integer> orderedItems = order.getOrderedItems();
        printMessage(OUTPUT_ORDER);
        for (Map.Entry<Menu, Integer> entry : orderedItems.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue() + COUNT.getMessage());
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

    public static void printIntroduce(int date) {
        System.out.println(PREVIEW.getMessage(date));
        System.out.println();
    }

    public static void printTotalBeforeDiscount(Result result) {
        System.out.println(OUTPUT_TOTAL_BEFORE_DISCOUNT.getMessage());
        System.out.println(result.getTotalBeforeDiscount() + "" + MONEY.getMessage());
        System.out.println();
    }


    public static void printServiceMenu(Result result) {
        System.out.println(OUTPUT_GIFT_MENU.getMessage());
        if (result.getServiceMenu() == TRUE) {
            System.out.println(SERVICE_MENU.getMessage());
        }
        if (result.getServiceMenu() == FALSE) {
            System.out.println(NONE.getMessage());
        }
        System.out.println();
    }

    public static void printBenefit(Result result) {
        System.out.println(OUTPUT_BENEFIT.getMessage());
        if (result.getdDayDiscount() == FALSE) {
            System.out.println(NONE.getMessage());
        }
        if (result.getdDayDiscount() != FALSE) {
            System.out.println(CHRISTMAS_DISCOUNT.getMessage() + result.getdDayDiscount() + "" + MONEY.getMessage());
        }
    }

    public static void printWeekday(Result result) {
        if (result.getWeekdayDiscount() != FALSE) {
            System.out.println(WEEKDAY_DISCOUNT.getMessage() + result.getWeekdayDiscount() + MONEY.getMessage());
        }
    }

    public static void printWeekend(Result result) {
        if (result.getWeekendDiscount() != FALSE) {
            System.out.println(WEEKEND_DISCOUNT.getMessage() + result.getWeekendDiscount() + MONEY.getMessage());
        }
    }

    public static void printSpecialDay(Result result) {
        if (result.getServiceMenu() == TRUE) {
            System.out.println(SPECIAL_DISCOUNT.getMessage() + result.getSpecialDiscount() + MONEY.getMessage());
            System.out.println(SERVICE_DISCOUNT.getMessage() + CHAMPAGNE + MONEY.getMessage());
        }
        System.out.println();
    }

    public static void printAllBenefit(Result result) {
        System.out.println(BENEFIT_ALL_DISCOUNT.getMessage());
        if (result.getTotalBenefit() != FALSE) {
            System.out.println("-" + result.getTotalBenefit() + MONEY.getMessage());
        }
        if (result.getTotalBenefit() == FALSE) {
            System.out.println(result.getTotalBenefit() + MONEY.getMessage());
        }
        System.out.println();
    }

    public static void printTotalAfterBenefit(Result result) {
        System.out.println(AFTER_BENEFIT_DISCOUNT.getMessage());
        System.out.println(result.getTotalAfterBenefit() + MONEY.getMessage());
        System.out.println();
    }

    public static void printEventBadge(Result result) {
        System.out.println(BADGE_DISCOUNT.getMessage());
        System.out.println(result.getBadge());
    }
}
