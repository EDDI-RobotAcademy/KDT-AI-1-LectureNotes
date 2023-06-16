package kr.eddi.demo.lectureClass.vue.problem.controller.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
//@RequiredArgsConstructor
@NoArgsConstructor
public class WatermelonResponseForm {
    final int WATERMELON_PRICE = 10000;
    public int getWatermelonsPrice(int watermelonCount) {
        int watermelonsPrice = WATERMELON_PRICE * watermelonCount;
        return watermelonsPrice;
    }
}
