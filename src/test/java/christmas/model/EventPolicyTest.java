package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.model.event.ChristmasDdayEvent;
import christmas.model.event.GiveawayEvent;
import christmas.model.event.SpecialEvent;
import christmas.model.event.WeekdayEvent;
import christmas.model.event.WeekendEvent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EventPolicyTest {

    @DisplayName("총주문 금액 10000원 이상부터 이벤트 적용 테스트")
    @Test
    void calculateDiscount_EqualCondition_Success() {
        //given
        int discount = 0;
        Reservation reservation = new Reservation("타파스-1,제로콜라-1", new ChristmasCalendar(25));
        EventPolicy christmasDdayEvent = new ChristmasDdayEvent(reservation);
        EventPolicy giveawayEvent = new GiveawayEvent(reservation);
        EventPolicy specialEvent = new SpecialEvent(reservation);
        EventPolicy weekdayEvent = new WeekdayEvent(reservation);
        EventPolicy weekendEvent = new WeekendEvent(reservation);
        //when
        //then
        assertThat(christmasDdayEvent.calculateDiscount()).isEqualTo(0);
        assertThat(giveawayEvent.calculateDiscount()).isEqualTo(0);
        assertThat(specialEvent.calculateDiscount()).isEqualTo(0);
        assertThat(weekdayEvent.calculateDiscount()).isEqualTo(0);
        assertThat(weekendEvent.calculateDiscount()).isEqualTo(0);
    }
}
