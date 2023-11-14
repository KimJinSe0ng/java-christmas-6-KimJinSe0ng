package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.Order;
import christmas.domain.Reservation;
import christmas.exception.ValidatorException;
import christmas.validator.Validator;

public class InputView {

    public static Reservation createReservation() {
        try {
            String input = Console.readLine();
            int date = Validator.convertStringToInt(input);

            return Reservation.from(date);
        } catch (ValidatorException exception) {
            OutputView.println(exception.getMessage());
            return createReservation();
        }
    }

    public static Order createOrder() {
        return null;
    }
}
