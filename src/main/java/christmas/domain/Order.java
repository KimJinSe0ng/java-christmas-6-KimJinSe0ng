package christmas.domain;

import christmas.validator.Validator;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Order {

    private Map<Menu, Integer> orderedItems;

    private Order(Map<Menu, Integer> orderedItems ) {
        this.orderedItems = orderedItems;
    }

    public static Order from(Map<Menu, Integer> orderMap) {
//        Map<Menu, Integer> orderMap = parseOrder(order);
        return new Order(orderMap);
    }

    public Map<Menu, Integer> getOrderedItems() {
        return orderedItems;
    }
}
