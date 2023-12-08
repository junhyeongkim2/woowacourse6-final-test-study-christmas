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
        assertThatThrownBy(() -> new Reservation("제로콜라-1", new Calender(5))).isInstanceOf(
                IllegalArgumentException.class);

    }

    @DisplayName("메뉴 한번에 20개 넘게 주문 시 예외 발생 테스트")
    @Test
    void createMenus_IfOverTwentyMenu_ExceptionThrow() {
        //given && when && then
        assertThatThrownBy(() -> new Reservation("제로콜라-19,타파스-20", new Calender(5))).isInstanceOf(
                IllegalArgumentException.class);

    }

    @DisplayName("존재하지 않는 메뉴일 경우 예외 발생 테스트")
    @Test
    void createMenus_IfNotContainMenu_ExceptionThrow() {
        //given && when && then
        assertThatThrownBy(() -> new Reservation("제로콜라-5,해산물찌개-1", new Calender(5))).isInstanceOf(
                IllegalArgumentException.class);

    }
}
