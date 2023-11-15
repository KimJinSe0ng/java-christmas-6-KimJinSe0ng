package christmas.validator;

import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.Menu;
import christmas.exception.ErrorMessage;
import christmas.exception.ValidatorException;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @DisplayName("날짜 문자열을 숫자로 바꾸는 테스트")
    @Test
    public void testConvertDateStringToInt_Success() {
        // Given
        String input = "20";

        // When
        int result = Validator.convertDateStringToInt(input);

        // Then
        assertEquals(20, result);
    }

    @DisplayName("날짜 문자열을 숫자로 바꾸는 테스트로 유효하지 않은 포맷을 입력했을 때 검증")
    @Test
    public void testConvertDateStringToInt_InvalidFormat() {
        // Given
        String input = "abc";

        // When/Then
        ValidatorException exception = assertThrows(ValidatorException.class,
                () -> Validator.convertDateStringToInt(input));
        assertEquals(ErrorMessage.INVALID_DATE.getMessage(), exception.getMessage());
    }

    @DisplayName("주문 메뉴 개수 문자열을 숫자로 바꾸는 것 검증")
    @Test
    public void testConvertOrderStringToInt_Success() {
        // Given
        String input = "2";

        // When
        int result = Validator.convertOrderStringToInt(input);

        // Then
        assertEquals(2, result);
    }

    @DisplayName("주문 메뉴 개수 문자열을 숫자로 바꾸는 검증 테스트로 유효하지 않은 포맷을 입력했을 때 검증")
    @Test
    public void testConvertOrderStringToInt_InvalidFormat() {
        // Given
        String input = "abc";

        // When, Then
        ValidatorException exception = assertThrows(ValidatorException.class,
                () -> Validator.convertOrderStringToInt(input));
        assertEquals(ErrorMessage.INVALID_ORDER.getMessage(), exception.getMessage());
    }

    @DisplayName("날짜가 달력 범위안에 있는지 검증")
    @Test
    public void testIsInRange_ValidDate() {
        // Given
        int date = 15;

        // When, Then
        assertDoesNotThrow(() -> Validator.isInRange(date));
    }

    @DisplayName("날짜가 달력 범위밖에 있는지 검증")
    @Test
    public void testIsInRange_InvalidDate() {
        // Given
        int date = 35;

        // When/Then
        ValidatorException exception = assertThrows(ValidatorException.class,
                () -> Validator.isInRange(date));
        assertEquals(ErrorMessage.INVALID_ORDER.getMessage(), exception.getMessage());
    }

    @DisplayName("메뉴 주문시 유효한 포맷으로 입력했는지 검증")
    @Test
    public void testIsValidOrderFormat_ValidOrderFormat() {
        // Given
        String order = "티본스테이크-2,초코케이크-1";

        // When
        boolean result = Validator.isValidOrderFormat(order);

        // Then
        assertTrue(result);
    }

    @DisplayName("메뉴 주문시 유효하지 않은 포맷으로 입력했는지 검증")
    @Test
    public void testIsValidOrderFormat_InvalidOrderFormat() {
        // Given
        String order = "InvalidOrderFormat";

        // When
        boolean result = Validator.isValidOrderFormat(order);

        // Then
        assertFalse(result);
    }

    @DisplayName("메뉴 주문시 입력한 문자열이 파싱이 가능한지 검증")
    @Test
    public void testParseOrder_ValidOrder() {
        // Given
        String order = "티본스테이크-2,초코케이크-1";

        // When
        Map<Menu, Integer> result = Validator.parseOrder(order);

        // Then
        assertTrue(result.containsKey(Menu.티본스테이크));
        assertEquals(2, result.get(Menu.티본스테이크));
        assertTrue(result.containsKey(Menu.초코케이크));
        assertEquals(1, result.get(Menu.초코케이크));
    }

    @DisplayName("메뉴 주문시 입력한 문자열이 파싱이 불가능한지 검증")
    @Test
    public void testParseOrder_InvalidOrder() {
        // Given
        String order = "InvalidOrder";

        // When, Then
        ValidatorException exception = assertThrows(ValidatorException.class,
                () -> Validator.parseOrder(order));
        assertEquals(ErrorMessage.INVALID_ORDER.getMessage(), exception.getMessage());
    }
}