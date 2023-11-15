package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.Menu;
import christmas.domain.Order;
import christmas.domain.Reservation;
import christmas.exception.ValidatorException;
import christmas.validator.Validator;
import java.util.Map;

public class InputView {

    public static Reservation createReservation() {
        try {
            String input = Console.readLine();
            int date = Validator.convertDateStringToInt(input);

            return Reservation.from(date);
        } catch (ValidatorException exception) {
            OutputView.println(exception.getMessage());
            return createReservation();
        }
    }

    public static Order createOrder() {
        try {
            String input = Console.readLine();
            Validator.isValidOrderFormat(input);
            Map<Menu, Integer> order = Validator.parseOrder(input);
//            OutputView.printOrder(order);
            return Order.from(order);
        } catch (ValidatorException exception) {
            OutputView.println(exception.getMessage());
            return createOrder();
        }
    }
}
