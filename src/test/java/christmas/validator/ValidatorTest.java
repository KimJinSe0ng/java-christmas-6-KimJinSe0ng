package christmas.validator;

import static org.junit.jupiter.api.Assertions.*;

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

}