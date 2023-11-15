package christmas.controller;

import christmas.domain.Order;
import christmas.view.InputView;
import christmas.view.OutputView;
import christmas.view.messages.PrintMessage;

public class OrderController {

    public static Order inputOrder() {
        OutputView.printMessage(PrintMessage.INPUT_ORDER);
        return InputView.createOrder();
    }
}
