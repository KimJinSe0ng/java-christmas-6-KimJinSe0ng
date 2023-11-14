package christmas.controller;

import christmas.domain.Order;
import christmas.domain.Reservation;
import christmas.domain.Result;

public class ResultController {

    public static Result createResult(Order order, Reservation reservation) {
        return Result.from(order.getOrderedItems(), reservation.getDate());
    }
}
