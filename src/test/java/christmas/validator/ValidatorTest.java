package christmas.validator;

import static org.junit.jupiter.api.Assertions.*;

import christmas.exception.ErrorMessage;
import christmas.exception.ValidatorException;
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
}