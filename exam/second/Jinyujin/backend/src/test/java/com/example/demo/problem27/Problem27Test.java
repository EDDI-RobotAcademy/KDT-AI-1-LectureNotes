package com.example.demo.problem27;

import com.example.demo.problem10.entity.Member;
import com.example.demo.problem10.entity.MemberRole;
import com.example.demo.problem10.entity.Role;
import com.example.demo.problem10.entity.RoleType;
import com.example.demo.problem10.service.AccountService;
import com.example.demo.problem17.controller.form.AccountLoginResponseForm;
import com.example.demo.problem17.controller.form.AccountRequestForm;
import com.example.demo.problem27.entity.Order;
import com.example.demo.problem27.form.AccountRoleResponseForm;
import com.example.demo.problem27.form.OrderRequestForm;
import com.example.demo.problem27.service.OrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Problem27Test {
    /*
        1. 일반 회원이 상품을 구매할 수 있도록 합니다
           - 로그인한 회원이 일반회원인지 확인합니다(확인하는 서비스가 필요한가?)
           -
     */

    @Autowired
    private AccountService accountService;

    @Autowired
    private OrderService orderService;

    @Test
    @DisplayName("일반 회원이 상품 구매")
    void 일반_회원_상품_구매() {

        final Long productId = 2L;
        final RoleType roleType = RoleType.NORMAL;

        AccountRoleResponseForm responseForm = new AccountRoleResponseForm(roleType);

        OrderRequestForm orderRequestForm = new OrderRequestForm(responseForm.getRoleType(), productId);
        Order order = orderService.order(orderRequestForm, roleType);
    }
}
