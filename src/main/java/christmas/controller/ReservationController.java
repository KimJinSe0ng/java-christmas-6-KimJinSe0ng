package christmas.controller;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.Reservation;
import christmas.exception.ValidatorException;
import christmas.validator.Validator;
import christmas.view.InputView;
import christmas.view.OutputView;
import christmas.view.messages.PrintMessage;

public class ReservationController {

    public static Reservation inputReservation() {
        OutputView.printMessage(PrintMessage.INPUT_INTRODUCE);
        return InputView.createReservation();
    }

//    private static Reservation createReservation() {
//        try {
//            String input = Console.readLine();
//            int date = Validator.convertStringToInt(input);
//
//            return Reservation.from(date);
//        } catch (ValidatorException exception) {
//            OutputView.println(exception.getMessage());
//            return createReservation();
//        }
//    }
}
