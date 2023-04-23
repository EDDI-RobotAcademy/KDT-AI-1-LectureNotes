package kr.eddi.demo.lectureClass.vue.problem6.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class FruitCostForm {

    final private int appleNum;
    final private String appleName;
    final private int watermelonNum;
    final private String watermelonName;

}
