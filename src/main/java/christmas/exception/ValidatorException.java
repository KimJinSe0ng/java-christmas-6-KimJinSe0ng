package christmas.exception;

public class ValidatorException extends IllegalArgumentException {
    private ValidatorException(
            ErrorMessage errorMessage,
            Exception exception
    ) {
        super(errorMessage.getMessage(), exception);
    }

    private ValidatorException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }

    public static ValidatorException of(
            ErrorMessage errorMessage,
            Exception exception
    ) {
        return new ValidatorException(errorMessage, exception);
    }

    public static ValidatorException from(ErrorMessage errorMessage) {
        return new ValidatorException(errorMessage);
    }
}
