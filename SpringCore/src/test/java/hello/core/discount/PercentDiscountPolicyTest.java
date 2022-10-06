package hello.core.discount;

import hello.core.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class PercentDiscountPolicyTest  {

    PercentDiscountPolicy discountPolicy = new PercentDiscountPolicy();

    @Test
    @DisplayName("VIP는 10%할인이 적용되어야 한다.")
    void vip_o(){
        //given
        Member member = new Member(1L, "memberA", Grade.Vip);
        MemberService memberService = new MemberServiceImpl(new MemoryMemberRepository());
        memberService.join(member);
        //when
        int price = discountPolicy.discount(member, 10000);
        //then
        assertThat(price).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않는다.")
    void vip_x() {
        //given
        Member member = new Member(1L, "memberA", Grade.Basic);
        MemberService memberService = new MemberServiceImpl(new MemoryMemberRepository());
        memberService.join(member);
        //when
        int price = discountPolicy.discount(member, 10000);
        //then
        assertThat(price).isEqualTo(10000);
    }

}