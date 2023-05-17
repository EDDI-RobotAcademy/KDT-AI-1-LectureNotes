package com.example.demo.problem.order.service.request;

import com.example.demo.problem.order.entity.Order;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;

@Getter
@RequiredArgsConstructor
public class OrderRegisterRequest {
    final private Long id;
    final private String userToken;
}
