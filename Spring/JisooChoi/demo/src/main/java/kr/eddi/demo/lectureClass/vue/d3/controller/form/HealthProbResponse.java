package kr.eddi.demo.lectureClass.vue.d3.controller.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class HealthProbResponse {
    private Integer healthList;

    public HealthProbResponse(Integer health){
        this.healthList = health;
    }
}
