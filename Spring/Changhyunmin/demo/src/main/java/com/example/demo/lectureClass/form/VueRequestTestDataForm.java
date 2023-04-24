package com.example.demo.lectureClass.form;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
public class VueRequestTestDataForm {

    final private String studentName;
    final private String studentMajor;
    final private Integer studentAge;
}