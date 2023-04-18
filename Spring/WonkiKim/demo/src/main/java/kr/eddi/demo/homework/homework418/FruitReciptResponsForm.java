package kr.eddi.demo.homework.homework418;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class FruitReciptResponsForm {
    Integer totalApplePrice;
    Integer totalWatermelonPrice;
    Integer totalPrice;

    public FruitReciptResponsForm(int totalApplePrice, int totalWatermelonPrice, int totalPrice) {
        this.totalApplePrice = totalApplePrice;
        this.totalWatermelonPrice = totalWatermelonPrice;
        this.totalPrice = totalPrice;
    }
}
