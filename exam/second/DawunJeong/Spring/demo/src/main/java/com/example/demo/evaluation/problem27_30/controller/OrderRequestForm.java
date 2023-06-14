package com.example.demo.evaluation.problem27_30.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class OrderRequestForm {
    final private String userToken;
    final private Long productId;

}
