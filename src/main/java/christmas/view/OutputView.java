package christmas.view;

import christmas.domain.Menu;
import christmas.domain.Order;
import christmas.view.messages.PrintMessage;
import java.util.Map;

public class OutputView {
    private static final String COLON = ": ";
    private static final String COUNT = "개";
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
            System.out.println(entry.getKey() + COLON + entry.getValue() + COUNT);
        }
    }
}
