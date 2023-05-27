package com.example.demo.problem.order.controller;

import com.example.demo.problem.account.entity.Account;
import com.example.demo.problem.account.service.AccountService;
import com.example.demo.problem.order.controller.form.OrderListRequestForm;
import com.example.demo.problem.order.controller.form.OrderRegisterRequestForm;
import com.example.demo.problem.order.controller.form.OrderResponseForm;
import com.example.demo.problem.order.service.OrderService;
import com.example.demo.problem.product.entity.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.demo.problem.account.entity.RoleType.BUSINESS;
import static com.example.demo.problem.account.entity.RoleType.NORMAL;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    final private OrderService orderService;
    final private AccountService accountService;

    @PostMapping("/register")
    public Boolean orderRegister (@RequestBody OrderRegisterRequestForm requestForm) {
        final Long accountId = accountService.findAccountId(requestForm.getAccountToken());

        return orderService.register(accountId, requestForm.toOrderRegisterRequest());
    }

    @GetMapping("/list")
    public List<OrderResponseForm> orderList (OrderListRequestForm requestForm) {
        final Long accountId = accountService.findAccountId(requestForm.getAccountToken());

        log.info("accountToken: " + requestForm.getAccountToken() + ", accountId: " + accountId);

        return orderService.orderList(accountId);
    }
}
