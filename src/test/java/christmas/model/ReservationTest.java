package christmas.model;

import christmas.model.event.GiveawayEvent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ReservationTest {

    @DisplayName("음료만 주문 시 예외 발생 테스트")
    @Test
    void createMenus_IfOnlyDrink_ExceptionThrow() {
        //given && when && then
        assertThatThrownBy(() -> new Reservation("제로콜라-1", new Calender(5))).isInstanceOf(IllegalArgumentException.class);

    }
}
