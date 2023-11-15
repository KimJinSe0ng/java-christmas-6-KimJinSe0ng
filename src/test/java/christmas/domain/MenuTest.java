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

    @DisplayName("음료인지 검증")
    @Test
    public void testIsBeverage() {
        // Given
        Menu cola = Menu.제로콜라;
        Menu wine = Menu.레드와인;
        Menu champagne = Menu.샴페인;
        Menu pasta = Menu.크리스마스파스타;

        // Then
        assertTrue(cola.isBeverage(), "제로콜라는 음료수");
        assertTrue(wine.isBeverage(), "레드와인은 음료수");
        assertTrue(champagne.isBeverage(), "샴페인은 음료수");
        assertFalse(pasta.isBeverage(), "크리스마스파스타는 음료수가 아님");
    }

    @DisplayName("디저트인지 검증")
    @Test
    public void testIsDessert() {
        // Given
        Menu cake = Menu.초코케이크;
        Menu iceCream = Menu.아이스크림;
        Menu pasta = Menu.크리스마스파스타;

        // Then
        assertTrue(cake.isDessert(), "초코케이크는 디저트");
        assertTrue(iceCream.isDessert(), "아이스크림은 디저트");
        assertFalse(pasta.isDessert(), "크리스마스파스타는 디저트가 아님");
    }

    @DisplayName("메인요리인지 검증")
    @Test
    public void testIsMain() {
        // Given
        Menu steak = Menu.티본스테이크;
        Menu ribs = Menu.바비큐립;
        Menu pasta = Menu.크리스마스파스타;
        Menu soup = Menu.양송이수프;

        // Then
        assertTrue(steak.isMain(), "티본스테이크는 메인요리");
        assertTrue(ribs.isMain(), "바비큐립은 메인요리");
        assertTrue(pasta.isMain(), "크리스마스파스타는 메인요리");
        assertFalse(soup.isMain(), "양송이수프는 메인요리가 아님");
    }
}