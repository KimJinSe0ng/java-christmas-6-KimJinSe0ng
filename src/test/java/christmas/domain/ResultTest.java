package christmas.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {

    @DisplayName("할인 전 총주문 금액 검증")
    @Test
    public void testCalculateTotalBeforeDiscount() {
        // Given
        Map<Menu, Integer> orderedItems = new HashMap<>();
        orderedItems.put(Menu.티본스테이크, 2);
        orderedItems.put(Menu.초코케이크, 1);

        int date = 20;

        // When
        Result result = Result.from(orderedItems, date);

        // Then
        assertEquals(125000, result.getTotalBeforeDiscount());
    }

    @DisplayName("할인 전 총주문 금액으로 증정 메뉴 검증")
    @Test
    public void testCalculateServiceMenuWithDiscount() {
        // Given
        Map<Menu, Integer> orderedItems = new HashMap<>();
        orderedItems.put(Menu.티본스테이크, 2);
        orderedItems.put(Menu.초코케이크, 1);

        int date = 20; // Any date

        // When
        Result result = Result.from(orderedItems, date);

        // Then
        assertEquals(1, result.getServiceMenu());
    }
}