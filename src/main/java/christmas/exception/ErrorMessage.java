package christmas.exception;

public enum ErrorMessage {
    INVALID_DATE("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_ORDER("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    CONTAIN_WHITESPACE("공백 없이 입력해야 합니다."),
    ENDS_WITH_DELIMITER("쉼표로 구분해야 합니다."),
    MAX_MENU_COUNT_EXCEEDED("메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다."),
    BEVERAGE_ONLY_ORDER("음료만 주문 시, 주문할 수 없습니다"),
    DUPLICATE_MENU("중복 메뉴를 입력할 수 없습니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}
