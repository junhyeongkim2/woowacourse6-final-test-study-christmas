package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.model.event.GiveawayEvent;
import christmas.model.event.WeekdayEvent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GiveawayEventTest {
    @DisplayName("증정 이벤트 생성 테스트")
    @Test
    void calculateDiscount_EqualCondition_Success() {
        //given
        EventPolicy giveawayEvent = new GiveawayEvent(new Reservation(27, "타파스-1,티본스테이크-1,제로콜라-1,초코케이크-5"));
        //when
        int discount = giveawayEvent.calculateDiscount();
        //then
        assertThat(discount).isEqualTo(-25000);
    }
}
