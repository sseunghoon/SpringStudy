package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        OrderService orderService = appConfig.orderService();
        MemberService memberService = appConfig.memberService();

        Long memberId = 1L;
        Member memberA = new Member(memberId, "memberA", Grade.Vip);
        memberService.join(memberA);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println(order);
    }
}
