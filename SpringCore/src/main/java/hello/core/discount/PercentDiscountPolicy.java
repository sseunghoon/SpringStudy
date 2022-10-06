package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class PercentDiscountPolicy implements DiscountPolicy{

    private final Double discountPercent = 0.1;
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.Vip) {
            return (int) (price - price * (1 - discountPercent));
        } else {
            return price;
        }
    }
}
