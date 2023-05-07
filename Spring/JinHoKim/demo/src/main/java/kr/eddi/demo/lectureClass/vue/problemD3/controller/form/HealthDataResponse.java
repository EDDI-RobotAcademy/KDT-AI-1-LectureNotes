package kr.eddi.demo.lectureClass.vue.problemD3.controller.form;

import lombok.Getter;

@Getter
public class HealthDataResponse {

    private Integer healthAmount;

    public HealthDataResponse(Integer healthAmount) {
        this.healthAmount = healthAmount;
    }

}
