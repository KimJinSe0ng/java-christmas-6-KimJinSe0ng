package christmas.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderTest {

    @DisplayName("주문이 생성되는지 검증 및 주문 항목이 일치한지 검증")
    @Test
    public void testCreateOrder() {
        // Given
        Map<Menu, Integer> orderMap = new HashMap<>();
        orderMap.put(Menu.양송이수프, 2);
        orderMap.put(Menu.초코케이크, 1);

        // When
        Order order = Order.from(orderMap);

        // Then
        assertNotNull(order, "주문이 생성되어야 함");
        assertEquals(orderMap, order.getOrderedItems(), "생성된 주문의 항목이 일치해야 함");
    }
}