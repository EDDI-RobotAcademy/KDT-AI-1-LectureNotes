package com.example.demo.lectureClass.basics.controller.problem.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class OrderedFruits {
    final private String name;
    final private Integer min;
}