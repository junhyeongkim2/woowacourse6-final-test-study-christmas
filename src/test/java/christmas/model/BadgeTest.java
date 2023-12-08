package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.model.event.ChristmasDdayEvent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BadgeTest {

    @DisplayName("없음 배지 생성 테스트")
    @Test
    void valueOf_EqualNONECondition_Success() {
        //given
        Badge badge;
        //when
        badge = Badge.valueOf(2000);
        //then
        assertThat(badge).isEqualTo(Badge.NONE);
    }

    @DisplayName("별 배지 생성 테스트")
    @Test
    void valueOf_EqualSTARCondition_Success() {
        //given
        Badge badge;
        //when
        badge = Badge.valueOf(5000);
        //then
        assertThat(badge).isEqualTo(Badge.STAR);
    }

    @DisplayName("트리 배지 생성 테스트")
    @Test
    void valueOf_EqualTREECondition_Success() {
        //given
        Badge badge;
        //when
        badge = Badge.valueOf(11000);
        //then
        assertThat(badge).isEqualTo(Badge.TREE);
    }


    @DisplayName("산타 배지 생성 테스트")
    @Test
    void valueOf_EqualSANTACondition_Success() {
        //given
        Badge badge;
        //when
        badge = Badge.valueOf(25000);
        //then
        assertThat(badge).isEqualTo(Badge.SANTA);
    }






}
