package kr.eddi.demo.lectureClass.vue.problem.controller.form;

import kr.eddi.demo.lectureClass.vue.problem.entity.Fruit;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor

public class FruitAppleWatermelonForm {
    final private int appleNumber;
    final private int watermelonNumber;

    public Fruit toFruit(){

        return new Fruit(appleNumber, watermelonNumber);
    }

}
