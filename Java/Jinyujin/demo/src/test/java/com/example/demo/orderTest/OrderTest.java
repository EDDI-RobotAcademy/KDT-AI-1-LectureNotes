package com.example.demo.orderTest;

import com.example.demo.lectureClass.testCode.account.Service.TestAccountService;
import com.example.demo.lectureClass.testCode.account.controller.form.TestAccountLoginResponseForm;
import com.example.demo.lectureClass.testCode.account.controller.form.TestAccountRequestForm;
import com.example.demo.lectureClass.testCode.order.controller.form.TestOrderRequestForm;
import com.example.demo.lectureClass.testCode.order.entity.TestOrder;
import com.example.demo.lectureClass.testCode.order.service.TestOrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class OrderTest {

    @Autowired
    private TestAccountService testAccountService;

    @Autowired
    private TestOrderService testOrderService;

    // 회원 Domain
    // 상품 Domain
    // 주문 Domain
    @Test
    @DisplayName("회원이 상품을 주문합니다")
    // 테스트 자체가 백로그가 되는 것
    // -> 도메인 분리가 된다
    void 회원이_상품을_주문합니다() {
        // 아까 만들어둔 계정으로 로그인
        final String email = "test@test.com";
        final String password = "test";
        final Long productId = 2L;
        final Long accountId = 1L;
        // 지금은 이렇게 지정해뒀기 때문에 딱 이대로만 실행해야 test pass함

        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        TestAccountLoginResponseForm responseForm = testAccountService.login(requestForm);

        String userToken = responseForm.getUserToken().toString(); // String 맞춰준 것

        TestOrderRequestForm orderRequestForm = new TestOrderRequestForm(userToken, productId);
        // 이제 오더리퀘스트폼이 필요
        // 상품 Id값이 필요하여 추가해줌
        // 얘는 상품이랑 토큰 정보 두 개 다 처리해야함
        // 그래서 사실상 orderService에서 order를 해줘야 하고
        // 주문이 들어갈꺼니까 리턴된 오더를 봐야함
        TestOrder order = testOrderService.order(orderRequestForm);

        assertEquals(productId, order.getTestProduct().getId());
        assertEquals(accountId, order.getTestAccount().getId());
    }
}
