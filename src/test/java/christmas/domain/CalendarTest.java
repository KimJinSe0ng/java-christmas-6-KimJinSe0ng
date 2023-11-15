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

    @DisplayName("주말에 해당하는 날짜를 입력했을 때 검증")
    @Test
    public void testIsWeekend() {
        // Given
        int weekend = 9;

        // When
        boolean result = Calendar.isWeekend(weekend);

        // Then
        assertTrue(result, "주말이 맞음");
    }

    @DisplayName("주말에 해당하지 않는 날짜를 입력했을 때 검증")
    @Test
    public void testIsNotWeekend() {
        // Given
        int weekend = 3;

        // When
        boolean result = Calendar.isWeekend(weekend);

        // Then
        assertFalse(result, "주말이 아님");
    }

    @DisplayName("특별한 날에 해당하는 날짜를 입력했을 때 검증")
    @Test
    public void testIsSpecialDay() {
        // Given
        int specialDay = 25;

        // When
        boolean result = Calendar.isSpecialDay(specialDay);

        // Then
        assertTrue(result, "특별한 날");
    }
}