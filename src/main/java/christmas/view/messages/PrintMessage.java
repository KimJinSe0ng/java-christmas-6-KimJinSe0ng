package christmas.view.messages;

public enum PrintMessage {
    INPUT_INTRODUCE("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    INPUT_RESERVATION("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    INPUT_ORDER("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),

    OUTPUT_RESULT("12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    OUTPUT_ORDER("<주문 메뉴>"),
    OUTPUT_TOTAL_BEFORE_DISCOUNT("<할인 전 총주문 금액>"),
    OUTPUT_GIFT_MENU("<증정 메뉴>"),
    OUTPUT_BENEFIT("<혜택 내역>"),
    OUTPUT_TOTAL_BENEFIT("<총혜택 금액>"),
    OUTPUT_TOTAL_AFTER_DISCOUNT("<할인 후 예상 결제 금액>"),
    OUTPUT_EVENT_BADGE("<12월 이벤트 배지>"),
    OUTPUT_PRECAUTIONS("총주문 금액 10,000원 이상부터 이벤트가 적용됩니다.\n"
            + "음료만 주문 시, 주문할 수 없습니다.\n"
            + "메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.\n"
            + "(e.g. 시저샐러드-1,티본스테이크-1,크리스마스파스타-1,제로콜라-3,아이스크림-1의 총개수는 7개)\n");

    private final String message;

    PrintMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}