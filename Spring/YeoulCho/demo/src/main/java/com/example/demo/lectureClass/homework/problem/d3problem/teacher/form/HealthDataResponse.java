package com.example.demo.lectureClass.homework.problem.d3problem.teacher.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
@Getter
@RequiredArgsConstructor
public class HealthDataResponse {
    private Integer healthAmount;

    public HealthDataResponse(Integer healthAmount) {
        this.healthAmount = healthAmount;
    }
}
