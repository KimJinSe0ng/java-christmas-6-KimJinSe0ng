package christmas.controller;

import christmas.domain.Order;
import christmas.domain.Reservation;
import christmas.domain.Result;

public class EventPlannerController {
    public static void run() {
        Reservation reservation = ReservationController.inputReservation();
        Order order = OrderController.inputOrder();
        Result result = ResultController.createResult(order, reservation);
        ResultController.printResult(result);

    }
}
