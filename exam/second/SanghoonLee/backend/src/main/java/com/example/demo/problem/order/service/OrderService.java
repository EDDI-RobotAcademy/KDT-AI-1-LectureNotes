package com.example.demo.problem.order.service;

import com.example.demo.problem.order.service.request.OrderRegisterRequest;

public interface OrderService {
    Boolean register(OrderRegisterRequest orderRegisterRequest);
}
