package christmas.model;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EventResultTest {

    @DisplayName("이벤트 결과 생성 테스트")
    @Test
    void of_EqualResult_Success() {
        //given
        EventResult eventResult = EventResult.of(new Reservation(5, "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1"));
        //when
        List<EventPolicy> events = eventResult.getEvents();
        //then
        assertThat(events.size()).isEqualTo(5);
    }

    @DisplayName("총혜택 금액 계산 테스트")
    @Test
    void calculateTotalBenefitAmount_EqualResult_Success() {
        //given
        EventResult eventResult = EventResult.of(new Reservation(5, "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1"));
        //when
        int totalBenefitAmount = eventResult.calculateTotalBenefitAmount();
        //then
        assertThat(totalBenefitAmount).isEqualTo(-4046 + -1400 + -25000);
    }

    @DisplayName("할인 후 예상 결제 금액 계산 테스트")
    @Test
    void calculateExpectedPaymentAmount_EqualResult_Success() {
        //given
        Reservation reservation = new Reservation(5, "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        EventResult eventResult = EventResult.of(reservation);
        //when
        int totalOderAmount = reservation.calculateTotalOrderAmount();
        int expectedPaymentAmount = eventResult.calculateExpectedPaymentAmount(totalOderAmount);
        //then
        assertThat(expectedPaymentAmount).isEqualTo((55000+54000+30000+3000) + (-4046 -1400) );
    }


}
