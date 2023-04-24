package com.example.demo.controller.lectureClass.homework.problem1;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Price {
    final private int ApplePrice = 2000 * 3;
    final private int WatermelonPrice = 10000 * 5;


    // public static int calculatePriceSum() static때문에 이도저도 안되는 상황이 발생
    // 근본적인 원인을 몰라 한참 삽질하던중 내부에 static을 제거해주니 간단히 문제가 해결
    public int calculatePriceSum() {
        int PriceSum = 0;
        PriceSum = ApplePrice + WatermelonPrice;

        return PriceSum;
    }
}