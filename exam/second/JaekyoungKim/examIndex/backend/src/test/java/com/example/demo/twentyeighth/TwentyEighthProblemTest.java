package com.example.demo.twentyeighth;

import com.example.demo.problem.account.controller.form.AccountLoginRequestForm;
import com.example.demo.problem.account.entity.RoleType;
import com.example.demo.problem.account.service.AccountService;
import com.example.demo.problem.order.controller.form.OrderListRequestForm;
import com.example.demo.problem.order.controller.form.OrderRegisterRequestForm;
import com.example.demo.problem.order.service.OrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.demo.problem.account.entity.RoleType.NORMAL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TwentyEighthProblemTest {

    @Autowired
    private AccountService accountService;

    @Autowired
    private OrderService orderService;
    
    @Test
    @DisplayName("상품 구매 내역 조회")
    void 구매_내역_조회하기 () {
        final AccountLoginRequestForm requestForm = new AccountLoginRequestForm("test@test.com", "test");
        final String userToken = accountService.login(requestForm.toAccountLoginRequest());
        final RoleType roleType = accountService.lookup(userToken);

        assertEquals(roleType, NORMAL);

        final OrderListRequestForm orderListRequestForm =
                new OrderListRequestForm(userToken);

        final Long accountId = accountService.findAccountId(orderListRequestForm.getAccountToken());

        assertTrue(orderService.orderList(accountId) != null);
    }
}
