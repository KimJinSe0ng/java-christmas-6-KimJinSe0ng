package christmas.validator;

import christmas.exception.ErrorMessage;
import christmas.exception.ValidatorException;

public class Validator {
    public static int convertStringToInt(String input) {
        try {
            isNumeric(input);
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw ValidatorException.of(ErrorMessage.INVALID_DATE, exception);
        }
    }

    private static boolean isNumeric(String input) {
        return input.matches("\\d+");
    }

    public static boolean isInRange(int date) {
        if (date < 1 || date > 31) {
            throw ValidatorException.from(ErrorMessage.INVALID_DATE);
        }
        return true;
    }
}
