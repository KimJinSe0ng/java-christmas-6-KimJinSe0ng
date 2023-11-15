package christmas.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuTest {

    @DisplayName("양송이 수프 가격 동일한지 검증")
    @Test
    public void testGetPrice() {
        // Given
        Menu menu = Menu.양송이수프;

        // When
        int price = menu.getPrice();

        // Then
        assertEquals(6_000, price, "양송이수프의 가격이 같음");
    }
}