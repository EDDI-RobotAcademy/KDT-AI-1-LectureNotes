package com.example.demo.problem.order.controller.form;

import com.example.demo.problem.order.service.request.OrderRegisterRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class OrderRegisterRequestForm {
    final private Long id;
    final private String userToken;

    public OrderRegisterRequest toOrderRegisterRequest() {
        return new OrderRegisterRequest(id, userToken);
    }
}
