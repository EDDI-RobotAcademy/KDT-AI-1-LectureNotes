package homework.testBank.test;

import utility.random.CustomRandom;

class Apple{
    private int applePrice;
    private int appleNum;
    private int appleAmount;

    public Apple() {}

    public void applePriceSave(){
        final int APPLE_MIN_PRICE = 5000;
        final int APPLE_MAX_PRICE = 10000;

        this.applePrice = CustomRandom.generateNumber(APPLE_MIN_PRICE, APPLE_MAX_PRICE);
    }

    public void appleNumSave(){
        final int APPLE_MIN_NUM = 3;
        final int APPLE_MAX_NUM = 5;

        this.appleNum = CustomRandom.generateNumber(APPLE_MIN_NUM, APPLE_MAX_NUM);
    }

    public void appleAmountSave(){
        this.appleAmount = applePrice * appleNum;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "applePrice=" + applePrice +
                ", appleNum=" + appleNum +
                ", appleAmount=" + appleAmount +
                '}';
    }
}

public class complexTest {
    public static void main(String[] args) {
        Apple apple = new Apple();
        apple.applePriceSave();
        apple.appleNumSave();
        apple.appleAmountSave();

        System.out.println(apple);
    }
}
