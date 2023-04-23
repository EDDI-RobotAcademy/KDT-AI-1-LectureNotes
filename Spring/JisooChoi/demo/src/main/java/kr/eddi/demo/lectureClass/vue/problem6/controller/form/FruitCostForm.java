package kr.eddi.demo.lectureClass.vue.problem6.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class FruitCostForm {

    final private int appleNum;
    final private int watermelonNum;
    public String myFruit;
    public int totalFruitCost;

}
