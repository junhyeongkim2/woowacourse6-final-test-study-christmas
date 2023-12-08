package christmas.model;

import christmas.model.event.ChristmasDdayEvent;
import java.util.EnumMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ChristmasDdayEventTest {

    @DisplayName("크리스마스 이벤트 생성 테스트")
    @Test
    void calculateDiscount_EqualCondition_Success() {
        //given
        EventPolicy christmasDdayEvent = new ChristmasDdayEvent(new Reservation( "타파스-1,티본스테이크-1,제로콜라-1",new Calender(25)));
        //when
        int discount = christmasDdayEvent.calculateDiscount();
        //then
        assertThat(discount).isEqualTo(-3400);
    }


}
