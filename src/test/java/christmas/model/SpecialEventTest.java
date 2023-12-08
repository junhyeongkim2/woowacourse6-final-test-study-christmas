package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.model.event.SpecialEvent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SpecialEventTest {
    @DisplayName("특별 이벤트 생성 테스트")
    @Test
    void calculateDiscount_EqualCondition_Success() {
        //given
        EventPolicy specialEvent = new SpecialEvent(new Reservation("타파스-1,티본스테이크-1,제로콜라-1,초코케이크-5", new ChristmasCalendar(25)));
        //when
        int discount = specialEvent.calculateDiscount();
        //then
        assertThat(discount).isEqualTo(-1000);
    }
}
