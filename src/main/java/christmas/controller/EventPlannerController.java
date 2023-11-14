package christmas.controller;

import christmas.domain.Reservation;

public class EventPlannerController {
    public static void run() {
        Reservation reservation = ReservationController.inputReservation();
    }
}
