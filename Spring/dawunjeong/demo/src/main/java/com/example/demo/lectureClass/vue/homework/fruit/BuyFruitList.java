package com.example.demo.lectureClass.vue.homework.fruit;

public class BuyFruitList {
    final private int applePrice = 3000;
    final private int waterMelonPrice = 5000;
    private int appleTotalPrice;
    private int waterMelonTotalPrice;

    public BuyFruitList() {
    }

    public int totalApplePrice (int appleNum) {
        appleTotalPrice = applePrice * appleNum;
        return appleTotalPrice;
    }
    public int totalWaterMelonPrice (int waterMelonNum) {
        waterMelonTotalPrice = waterMelonPrice * waterMelonNum;
        return waterMelonTotalPrice;
    }
}
