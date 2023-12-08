package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.model.event.ChristmasDdayEvent;
import christmas.model.event.WeekdayEvent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WeekdayEventTest {
    @DisplayName("평일 이벤트 생성 테스트")
    @Test
    void calculateDiscount_EqualCondition_Success() {
        //given
        EventPolicy weekdayEvent = new WeekdayEvent(new Reservation(27, "타파스-1,티본스테이크-1,제로콜라-1,초코케이크-5"));
        //when
        int discount = weekdayEvent.calculateDiscount();
        //then
        assertThat(discount).isEqualTo(2023 * 5);
    }
}
