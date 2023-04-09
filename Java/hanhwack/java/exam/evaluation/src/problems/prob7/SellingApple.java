package problems.prob7;

import customLibrary.CustomRandom;

public class SellingApple {
    private final int basicPrice = 2000;
    private final int MIN_INCREASE_PER = 3;
    private final int MAX_INCREASE_PER = 20;

    private int increaseRate;

    public SellingApple() {
        increaseRate = CustomRandom.generateNumber(MIN_INCREASE_PER, MAX_INCREASE_PER);
    }
    public void getApplePrice() {
        System.out.println("오늘의 사과 가격은 " + basicPrice * (1 + (increaseRate / 100f))+"원 입니다");
    }
}
