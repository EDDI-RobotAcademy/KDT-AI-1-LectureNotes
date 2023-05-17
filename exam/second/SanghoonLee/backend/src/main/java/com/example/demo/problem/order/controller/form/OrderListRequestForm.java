package com.example.demo.problem.order.controller.form;

import lombok.Getter;

@Getter
public class OrderListRequestForm {
    final private String accountToken;

    public OrderListRequestForm(String accountToken) {
        this.accountToken = accountToken;
    }
}
