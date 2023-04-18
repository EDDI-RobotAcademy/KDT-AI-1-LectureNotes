package kr.eddi.demo.lectureClass.vue.controller.form.shop;

import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
public class WatermelonResponseForm {
    final int WATERMELON_PRICE = 10000;
    public int getWatermelonsPrice(int watermelonCount) {
        int watermelonsPrice = WATERMELON_PRICE * watermelonCount;
        return watermelonsPrice;
    }
}