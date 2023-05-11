package com.example.demo.orderTest;

import com.example.demo.lectureClass.account.controller.form.TestAccountLoginResponseForm;
import com.example.demo.lectureClass.account.controller.form.TestAccountRequestForm;
import com.example.demo.lectureClass.account.service.TestAccountService;
import com.example.demo.lectureClass.order.controller.form.TestOrderRequestForm;
import com.example.demo.lectureClass.order.entity.TestOrder;
import com.example.demo.lectureClass.order.service.TestOrderService;
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
    void 회원이_상품을_주문합니다 () {
        final String email = "test@test.com";
        final String password = "test";
        final Long productId = 2L;
        final Long accountId = 1L;

        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        TestAccountLoginResponseForm responseForm = testAccountService.login(requestForm);

        String userToken = responseForm.getUserToken().toString();

        TestOrderRequestForm orderRequestForm = new TestOrderRequestForm(userToken, productId);
        TestOrder order = testOrderService.order(orderRequestForm);

        assertEquals(productId, order.getTestProduct().getId());
        assertEquals(accountId, order.getTestAccount().getId());
    }
}