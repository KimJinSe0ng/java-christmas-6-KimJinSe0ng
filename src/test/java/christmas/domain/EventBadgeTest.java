package christmas.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EventBadgeTest {

    @DisplayName("배지가 별인지 검증")
    @Test
    public void testGetBadge_Star() {
        // Given
        int totalAfterBenefit = 4000;

        // When
        EventBadge badge = EventBadge.getBadge(totalAfterBenefit);

        // Then
        assertEquals(EventBadge.STAR, badge, "별 배지");
    }

}