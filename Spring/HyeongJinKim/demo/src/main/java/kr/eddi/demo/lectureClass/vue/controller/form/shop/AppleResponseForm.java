package kr.eddi.demo.lectureClass.vue.controller.form.shop;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
public class AppleResponseForm {
    final int APPLE_PRICE = 2000;
    public int getApplesPrice(int appleCount) {
        int applesPrice = APPLE_PRICE * appleCount;
        return applesPrice;
    }
}