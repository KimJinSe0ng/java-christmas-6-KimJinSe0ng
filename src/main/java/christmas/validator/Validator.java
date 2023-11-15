package christmas.validator;

import christmas.domain.Menu;
import christmas.exception.ErrorMessage;
import christmas.exception.ValidatorException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final String DELIMITER = ",";
    private static final int FIRST_DAY = 1;
    private static final int LAST_DAY = 31;
    private static final int MAX_MENU_COUNT = 20;
    private static final int MIN_MUST_COUNT = 1;
    private static final int TRUE = 1;
    private static final int FALSE = 0;
    public static int convertDateStringToInt(String input) {
        try {
            isNumeric(input);
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw ValidatorException.of(ErrorMessage.INVALID_DATE, exception);
        }
    }

    public static int convertOrderStringToInt(String input) {
        try {
            isNumeric(input);
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw ValidatorException.of(ErrorMessage.INVALID_ORDER, exception);
        }
    }

    private static boolean isNumeric(String input) {
        return input.matches("\\d+");
    }

    public static void isInRange(int date) {
        if (date < FIRST_DAY || date > LAST_DAY) {
            throw ValidatorException.from(ErrorMessage.INVALID_ORDER);
        }
    }

    public static boolean isValidOrderFormat(String order) {
        try {
            String regex = "([\\w가-힣]+-\\d+,)*[\\w가-힣]+-\\d+";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(order);
            return matcher.matches();
        } catch (IllegalArgumentException exception) {
            throw ValidatorException.of(ErrorMessage.INVALID_ORDER, exception);
        }
    }


    public static Map<Menu, Integer> parseOrder(String order) {
        try {
            Map<Menu, Integer> orderMap = new HashMap<>();
            Set<Menu> uniqueMenus = new HashSet<>();
            String[] items = order.split(",");
            int count = 0;
            int beverageFlag = FALSE;
            for (String item : items) {
                String[] parts = item.split("-");
                validateNonNumericString(parts[0]); // 처음 들어온 값이 숫자면 에러
                Menu menu = getMenuByName(parts[0]);
                if (!menu.isBeverage()) {
                    beverageFlag = TRUE;
                }
                isDuplicate(uniqueMenus, menu);
                if (parts.length == 2) {
                    int quantity = convertOrderStringToInt(parts[1]);
                    isMinCount(quantity);
                    count += quantity;
                    orderMap.put(menu, quantity);
                }
            }
            isOnlyBeverageOrder(beverageFlag);
            isMaxCount(count);
            return orderMap;
        } catch (IllegalArgumentException exception) {
            throw ValidatorException.of(ErrorMessage.INVALID_ORDER, exception);
        }
    }

    private static void isOnlyBeverageOrder(int beverageFlag) {
        if (beverageFlag == FALSE) {
            throw ValidatorException.from(ErrorMessage.INVALID_ORDER);
        }
    }

    private static void isDuplicate(Set<Menu> uniqueMenus, Menu menu) {
        if (!uniqueMenus.add(menu)) {
            throw ValidatorException.from(ErrorMessage.INVALID_ORDER);
        }
    }

    private static void isMinCount(int quantity) {
        if (quantity < MIN_MUST_COUNT) {
            throw ValidatorException.from(ErrorMessage.INVALID_ORDER);
        }
    }

    private static void isMaxCount(int count) {
        if (count > MAX_MENU_COUNT) {
            throw ValidatorException.from(ErrorMessage.INVALID_ORDER);
        }
    }

    public static void validateNonNumericString(String input) {
        if (isNumeric(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
        }
    }

    public static Menu getMenuByName(String menuName) {
        for (Menu menu : Menu.values()) {
            if (menu.name().equalsIgnoreCase(menuName)) {
                return menu;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
    }


    public static void validateContainWhiteSpace(String input) {
        if (hasWhiteSpace(input)) {
            throw ValidatorException.from(ErrorMessage.CONTAIN_WHITESPACE);
        }
    }

    public static void validateEndsWithDelimiter(String input) {
        if (isEndsWithDelimiter(input)) {
            throw ValidatorException.from(ErrorMessage.ENDS_WITH_DELIMITER);
        }
    }

    private static boolean hasWhiteSpace(String input) {
        return input.chars().anyMatch(Character::isWhitespace);
    }

    private static boolean isEndsWithDelimiter(String input) {
        return input.endsWith(DELIMITER);
    }
}
