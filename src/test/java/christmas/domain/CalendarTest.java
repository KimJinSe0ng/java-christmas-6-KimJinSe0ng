package christmas.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalendarTest {

    @DisplayName("평일에 해당하는 날짜를 입력했을 때 검증")
    @Test
    public void testIsWeekday() {
        // Given
        int weekday = 5;

        // When
        boolean result = Calendar.isWeekday(weekday);

        // Then
        assertTrue(result, "평일이 맞음");
    }

    @DisplayName("평일에 해당하지 않는 날짜를 입력했을 때 검증")
    @Test
    public void testIsNotWeekday() {
        // Given
        int weekday = 9;

        // When
        boolean result = Calendar.isWeekday(weekday);

        // Then
        assertFalse(result, "평일이 아님");
    }
}