package christmas.domain;

import christmas.validator.Validator;
import java.util.HashMap;
import java.util.Map;

public class Order {

    private Map<Menu, Integer> orderedItems;

    private Order(Map<Menu, Integer> orderedItems) {
        this.orderedItems = orderedItems;
    }

    public static Order from(String order) {
        Map<Menu, Integer> orderMap = parseOrderWithoutRegex(order);
        return new Order(orderMap);
    }

    private static Map<Menu, Integer> parseOrderWithoutRegex(String order) {
        Map<Menu, Integer> orderMap = new HashMap<>();
        String[] items = order.split(",");

        for (String item : items) {
            String[] parts = item.trim().split("-");
            for (String part :
                    parts) {
                System.out.println("part = " + part);
            }
            if (parts.length == 2) {
                String menuName = parts[0];
                int quantity = Validator.convertStringToIntTwo(parts[1]);

                Menu menu = getMenuByName(menuName);
                orderMap.put(menu, quantity);
            }
        }

        return orderMap;
    }


    private static Menu getMenuByName(String menuName) {
        try {
            return Menu.valueOf(menuName.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 메뉴입니다. 다시 입력해 주세요.");
        }
    }

    public Map<Menu, Integer> getOrderedItems() {
        return orderedItems;
    }
}
