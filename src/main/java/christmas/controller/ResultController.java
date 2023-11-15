package christmas.controller;

import christmas.domain.Order;
import christmas.domain.Reservation;
import christmas.domain.Result;
import christmas.view.OutputView;

public class ResultController {

    public static Result createResult(Order order, Reservation reservation) {
        OutputView.printOrder(order);
        System.out.println();
        return Result.from(order.getOrderedItems(), reservation.getDate());
    }

    public static void printResult(Result result) {
        OutputView.printAllEvents(result);
    }
}
