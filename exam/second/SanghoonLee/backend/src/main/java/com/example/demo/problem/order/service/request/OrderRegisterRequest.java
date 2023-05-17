package com.example.demo.problem.order.service.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class OrderRegisterRequest {
    final private Long productId;

    public OrderRegisterRequest(Long productId) {
        this.productId = productId;
    }
}
