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
}