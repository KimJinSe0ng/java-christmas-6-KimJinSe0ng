package christmas.view;

import christmas.view.messages.PrintMessage;

public class OutputView {
    public static void println(Object data) {
        System.out.println(data);

    }
    public static void printMessage(final PrintMessage message) {
        System.out.println(message.getMessage());
    }
}
