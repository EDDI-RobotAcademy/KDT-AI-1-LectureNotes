package com.example.demo.test06.controller.form;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
public class VueRequestTestForm {
    final private String studentName;
    final private String studentMajor;
    final private Integer studentAge;
}
