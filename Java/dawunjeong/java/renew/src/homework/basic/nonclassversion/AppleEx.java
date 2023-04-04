package homework.basic.nonclassversion;

import utility.random.CustomRandom;

public class AppleEx {
    public static void main(String[] args) {
        final int applePrice;
        final int appleNum;
        final int PRICE_MIN = 5000;
        final int PRICE_MAX = 10000;
        final int APPLENUM_MIN = 3;
        final int APPLENUM_MAX = 5;

        final int totalPrice;

        applePrice = CustomRandom.generateNumber(PRICE_MIN, PRICE_MAX);
        appleNum = CustomRandom.generateNumber(APPLENUM_MIN, APPLENUM_MAX);
        totalPrice = applePrice * appleNum;

        System.out.println("사과의 가격: " + applePrice + "원");
        System.out.println("수확한 사과의 개수: " + appleNum + "개");
        System.out.println("수확한 사과의 전체 가격: " + totalPrice + "원");

    }
}
