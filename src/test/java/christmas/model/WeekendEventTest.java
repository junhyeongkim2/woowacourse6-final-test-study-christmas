package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.model.event.WeekdayEvent;
import christmas.model.event.WeekendEvent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WeekendEventTest {

    @DisplayName("주말 이벤트 생성 테스트")
    @Test
    void calculateDiscount_EqualCondition_Success() {
        //given
        EventPolicy weekendEvent = new WeekendEvent(new Reservation( "타파스-1,티본스테이크-2,제로콜라-1,초코케이크-5",new Calender(29)));
        //when
        int discount = weekendEvent.calculateDiscount();
        //then
        assertThat(discount).isEqualTo(-(2023 * 2));
    }
}
