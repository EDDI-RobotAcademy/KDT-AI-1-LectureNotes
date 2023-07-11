package kr.eddi.demo.lectureClass.vue.problem.controller.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
//@RequiredArgsConstructor
@NoArgsConstructor
public class AppleResponseForm {
    final int APPLE_PRICE = 2000;

    public int getApplesPrice(int appleCount) {
        int applesPrice = APPLE_PRICE * appleCount;
        return applesPrice;
    }
}