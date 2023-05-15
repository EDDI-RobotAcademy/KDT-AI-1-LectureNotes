package com.example.demo.lectureClass.order.controller.form;

import com.example.demo.lectureClass.order.entity.TestOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TestOrderRequestForm {
    final private String userToken;
    final private Long productId;
}