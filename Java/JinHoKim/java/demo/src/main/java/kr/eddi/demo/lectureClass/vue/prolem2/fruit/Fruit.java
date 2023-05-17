package kr.eddi.demo.lectureClass.vue.prolem2.fruit;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class Fruit {
    final int APPLE_PRICE = 2000;
    final int WATERMELON_PRICE = 10000;

    public int purchaseApple(int APPLE_NUN) {
        int totalApplePrice = APPLE_PRICE * APPLE_NUN;
        return totalApplePrice;
    }

    public int purchaseWatermelon(int WATERMELON_NUN) {
        int totalWatermelonPrice = WATERMELON_PRICE * WATERMELON_NUN;
        return totalWatermelonPrice;
    }
}
