package kr.eddi.demo.lectureClass.vue.d3.controller.form;

import lombok.Getter;

@Getter
public class HealthDataResponse {
    private Integer HealthAmount;

    public HealthDataResponse(Integer healthAmount) {
        HealthAmount = healthAmount;
    }
}
