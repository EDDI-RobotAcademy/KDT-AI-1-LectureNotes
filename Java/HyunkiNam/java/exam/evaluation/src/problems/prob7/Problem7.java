package problems.prob7;

import customLibrary.CustomRandom;

public class Problem7 {
    public static void main(String[] args) {
        final int applePrice = 2000;
        double variancePrice = (CustomRandom.generateNumber(3,20));
        int finalApplePrice = (int)(applePrice * (1 + variancePrice/100));

        System.out.println("원래 사과 가격 : " + applePrice + " / 가격 인상률 : " +
                variancePrice + "% / 최종 사과 가격 : " + finalApplePrice);
    }
}
