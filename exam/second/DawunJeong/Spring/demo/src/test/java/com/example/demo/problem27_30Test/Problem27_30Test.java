package com.example.demo.problem27_30Test;

import com.example.demo.evaluation.problem10_14_17_20.controller.form.AccountLoginRequestForm;
import com.example.demo.evaluation.problem10_14_17_20.controller.form.AccountLoginResponseForm;
import com.example.demo.evaluation.problem10_14_17_20.service.AccountService;
import com.example.demo.evaluation.problem27_30.controller.OrderRequestForm;
import com.example.demo.evaluation.problem27_30.entity.SampleOrder;
import com.example.demo.evaluation.problem27_30.service.OrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// 문제 27 ~ 28번
@SpringBootTest
public class Problem27_30Test {
    @Autowired
    private AccountService accountService;
    @Autowired
    private OrderService orderService;

    @Test
    @DisplayName("문제 27번. 일반 회원이 로그인 후 상품 구매하기")
    void 일반_회원이_로그인하고_상품_구매 () {
        final String email = "normal1@test.com";
        final String password = "test";
        final Long productId = 2L;
        final Long accountId = 1L;

        AccountLoginRequestForm accountLoginRequestForm = new AccountLoginRequestForm(email, password);
        AccountLoginResponseForm accountLoginResponseForm = accountService.login(accountLoginRequestForm);

        String userToken= accountLoginResponseForm.getUserToken().toString();

        OrderRequestForm orderRequestForm = new OrderRequestForm(userToken, productId);
        SampleOrder sampleOrder = orderService.order(orderRequestForm, accountId);

        assertEquals(accountId, sampleOrder.getAccount().getId());
        assertEquals(productId, sampleOrder.getProduct().getId());
    }

    @Test
    @DisplayName("문제 28번. 상품 구매 내역 조회하기")
    void 상품_구매_내역_조회 () {
        final String email = "normal1@test.com";
        final String password = "test";
        final Long accountId = 1L;

        AccountLoginRequestForm accountLoginRequestForm = new AccountLoginRequestForm(email, password);
        AccountLoginResponseForm accountLoginResponseForm = accountService.login(accountLoginRequestForm);

        String userToken= accountLoginResponseForm.getUserToken().toString();

        List<SampleOrder> orderList = orderService.list(accountId);
        assertTrue(orderList != null);
    }
}
