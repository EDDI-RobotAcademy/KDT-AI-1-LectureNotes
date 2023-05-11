package kr.eddi.demo.orderTest;

import kr.eddi.demo.testCode.account.service.TestAccountService;
import kr.eddi.demo.testCode.order.service.TestOrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderTest {
    @Autowired
    private TestAccountService testAccountService;

    @Autowired
    private TestOrderService testOrderService;

    @Test
    @DisplayName("회원이 상품을 주문합니다.")

    void 회원이_상품을_주문합니다(){
        final String email = "test@test.com";
        final String password = "test";
        final Long productId = 1L;
        final Long accountID = 2L;

    }

    /*
    회원서비스
    오더서비스


    주문함수
    데이터
    데이터로 회원폼 생성
    데이터로 로그인

    유저토큰 지정

    데이터로 오더폼 생성
    그리고 오더..?

    상품아이디와 오더의 상품아이디가 일치하는지
    회원아이디와 오더의  회원아이디가 일치하는지
     */
}
