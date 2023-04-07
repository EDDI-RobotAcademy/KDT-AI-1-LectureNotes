package practice.firstProb2;

import utility.Random;

import java.util.List;

public class FirstProb2 {
    final int PRICE_START = 5000;
    final int PRICE_END = 10000;
    final int APPLE_NUM_START = 3;
    final int APPLE_NUM_END = 5;

    public int applePrice() {
        int applePrice;
        applePrice = Random.generateNumber(PRICE_START, PRICE_END);
        return applePrice;
    }

    public int appleGet() {
        int appleNum;
        appleNum = Random.generateNumber(APPLE_NUM_START, APPLE_NUM_END);
        return appleNum;
    }

    public void totalPrice() {
        int totalPrice = 0;
        for (int i = 0; i < appleGet(); i++) {
            totalPrice = applePrice() * appleGet();
        }
        System.out.println("수확하여 얻은 사과의 전체 가격: " + totalPrice);
    }
}
