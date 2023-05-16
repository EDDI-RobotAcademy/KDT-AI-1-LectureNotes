package com.example.demo.lectureClass.vue.d3.homework.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class D3HealthDataResponseForm {
    String date;
    Integer healthAmount;

    public D3HealthDataResponseForm(String date, Integer healthAmount) {
        this.date = date;
        this.healthAmount = healthAmount;
    }
}
