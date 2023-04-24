package com.example.demo.lectureClass.vue.homework.fruit;

public class BuyFruit {
    final private int applePrice = 2000;
    final private int waterMelonPrice = 10000;
    private int appleTotalPrice;
    private int waterMelonTotalPrice;

    public BuyFruit() {
    }

    public int calculateApplePrice (int appleNum) {
        appleTotalPrice = applePrice * appleNum;
        return appleTotalPrice;
    }
    public int calculateWaterMelonPrice (int waterMelonNum) {
        waterMelonTotalPrice = waterMelonPrice * waterMelonNum;
        return waterMelonTotalPrice;
    }
}
