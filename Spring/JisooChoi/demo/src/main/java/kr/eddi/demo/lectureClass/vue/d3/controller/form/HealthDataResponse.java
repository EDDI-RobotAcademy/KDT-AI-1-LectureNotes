package kr.eddi.demo.lectureClass.vue.d3.controller.form;

import lombok.Getter;

@Getter
public class HealthDataResponse {
    private Integer healthAmount;

    /*
        인자 값으로 랜덤 값을 받아와서 값을 넣어주고
        HealthDataResponse 타입으로 반환한다.
    */
    public HealthDataResponse(Integer healthAmount) {
        this.healthAmount = healthAmount;
    }
}