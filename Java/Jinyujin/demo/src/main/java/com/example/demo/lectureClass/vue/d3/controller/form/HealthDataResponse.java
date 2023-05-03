package com.example.demo.lectureClass.vue.d3.controller.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Getter
public class HealthDataResponse {

    private Integer healthAmount;
    private LocalDate date;

    public HealthDataResponse(Integer healthAmount, LocalDate date) {
        this.healthAmount = healthAmount;
        this.date = date;
    }
}
