package com.example.demo.twentyseventh;

import com.example.demo.problem.account.controller.form.AccountLoginRequestForm;
import com.example.demo.problem.account.entity.RoleType;
import com.example.demo.problem.account.service.AccountService;
import com.example.demo.problem.order.controller.form.OrderRegisterRequestForm;
import com.example.demo.problem.order.service.OrderService;
import com.example.demo.problem.product.controller.form.ProductRegisterRequestForm;
import com.example.demo.problem.product.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.demo.problem.account.entity.RoleType.NORMAL;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TwentyseventhProblemTest {

    @Autowired
    private AccountService accountService;

    @Autowired
    private OrderService orderService;

    @Test
    @DisplayName("상품 구매 테스트")
    void 상품_구매 () {
        final AccountLoginRequestForm requestForm = new AccountLoginRequestForm("test@test.com", "test");
        final String userToken = accountService.login(requestForm.toAccountLoginRequest());
        final RoleType roleType = accountService.lookup(userToken);

        assertEquals(roleType, NORMAL);

        final OrderRegisterRequestForm orderRegisterRequestForm =
                new OrderRegisterRequestForm(3L, userToken);

        final Long accountId = accountService.findAccountId(orderRegisterRequestForm.getAccountToken());

        assertTrue(orderService.register(accountId, orderRegisterRequestForm.toOrderRegisterRequest()));
    }
}
