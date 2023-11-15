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

    @DisplayName("할인 전 총주문 금액으로 증정 메뉴가 있는 것을 검증")
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

    @DisplayName("할인 전 총주문 금액으로 증정 메뉴가 없는 것을 검증")
    @Test
    public void testCalculateServiceMenuWithoutDiscount() {
        // Given
        Map<Menu, Integer> orderedItems = new HashMap<>();
        orderedItems.put(Menu.티본스테이크, 1);

        int date = 20;

        // When
        Result result = Result.from(orderedItems, date);

        // Then
        assertEquals(0, result.getServiceMenu());
    }

    @DisplayName("크리스마스 디데이 할인 검증")
    @Test
    public void testCalculateBenefitWithDDayDiscount() {
        // Given
        Map<Menu, Integer> orderedItems = new HashMap<>();
        orderedItems.put(Menu.티본스테이크, 2);
        orderedItems.put(Menu.초코케이크, 1);

        int date = 25;

        // When
        Result result = Result.from(orderedItems, date);

        // Then
        assertEquals(3400, result.getdDayDiscount());
    }

    @DisplayName("총혜택 금액에 따른 배지 부여 검증")
    @Test
    public void testCalculateEventBadge() {
        // Given
        Map<Menu, Integer> orderedItems = new HashMap<>();
        orderedItems.put(Menu.티본스테이크, 2);
        orderedItems.put(Menu.초코케이크, 1);

        int date = 20;

        // When
        Result result = Result.from(orderedItems, date);

        // Then
        assertEquals("산타", result.getBadge());
    }
}