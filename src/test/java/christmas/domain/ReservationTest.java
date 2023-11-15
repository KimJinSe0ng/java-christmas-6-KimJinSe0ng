package christmas.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReservationTest {

    @DisplayName("유효한 날짜로 Reservation 객체가 생성되는지 검증")
    @Test
    public void testCreateReservationWithValidDate() {
        // Given
        int validDate = 10;

        // When
        Reservation reservation = Reservation.from(validDate);

        // Then
        assertNotNull(reservation, "Reservation 객체가 생성되어야 한다.");
        assertEquals(validDate, reservation.getDate(), "생성된 Reservation의 날짜가 일치해야 한다.");
    }
}