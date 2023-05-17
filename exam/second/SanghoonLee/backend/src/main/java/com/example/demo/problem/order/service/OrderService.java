package com.example.demo.problem.order.service;

import com.example.demo.problem.order.controller.form.OrderResponseForm;
import com.example.demo.problem.order.service.request.OrderRegisterRequest;
import com.example.demo.problem.product.entity.Product;

import java.util.List;

public interface OrderService {
    Boolean register(Long id, OrderRegisterRequest orderRegisterRequest);
    List<OrderResponseForm> orderList (Long accountId);
}
