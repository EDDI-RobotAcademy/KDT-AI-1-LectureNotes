package kr.eddi.demo.lectureClass.vue.problem.controller.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
//@RequiredArgsConstructor
@NoArgsConstructor
public class WatermelonResponseForm2 {
    private Integer watermelonCountData;

    public WatermelonResponseForm2(Integer watermelonCountData) {
        this.watermelonCountData = watermelonCountData;
    }
}