package com.example.demo.problem.order.service;

import com.example.demo.problem.order.OrderRepository;
import com.example.demo.problem.order.entity.Order;
import com.example.demo.problem.order.service.request.OrderRegisterRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    final private OrderRepository orderRepository;

    @Override
    public Boolean register(OrderRegisterRequest orderRegisterRequest) {
        final Order order = new Order();
        //orderRepository.save(orderRegisterRequest.toOrder());
        return true;
    }
}
