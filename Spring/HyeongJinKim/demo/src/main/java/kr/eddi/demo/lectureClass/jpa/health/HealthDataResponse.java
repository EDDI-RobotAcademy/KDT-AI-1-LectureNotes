package kr.eddi.demo.lectureClass.jpa.health;

import lombok.Getter;

@Getter
public class HealthDataResponse {
    private Integer healthAmount;

    public HealthDataResponse(Integer healthAmount) {
        this.healthAmount = healthAmount;
    }
}