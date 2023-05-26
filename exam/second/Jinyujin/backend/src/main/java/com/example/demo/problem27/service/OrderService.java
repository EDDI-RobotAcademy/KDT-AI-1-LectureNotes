package com.example.demo.problem27.service;

import com.example.demo.problem10.entity.RoleType;
import com.example.demo.problem27.entity.Order;
import com.example.demo.problem27.form.OrderRequestForm;

public interface OrderService {
    Order order(OrderRequestForm orderRequestForm, RoleType roleType);
}
