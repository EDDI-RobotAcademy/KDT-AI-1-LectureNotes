package javaProbs;

import utility.random.CustomRandom;

public class Prob2 {
    public static void main(String[] args) {
        final int MIN_PRICE = 5000;
        final int MAX_PRICE = 10000;
        final int MIN_COUNT = 3;
        final int MAX_COUNT = 5;
        int appleCount = CustomRandom.generateNumber(MIN_COUNT, MAX_COUNT);
        int applePrice = CustomRandom.generateNumber(MIN_PRICE, MAX_PRICE);

        System.out.printf("오늘의 사과 가격은 %d원 입니다.\n", applePrice);
        System.out.printf("오늘 수확한 사과는 %d개 입니다.\n", appleCount);
        System.out.printf("사과 %d개의 가격은 %d원 입니다.\n", appleCount, applePrice * appleCount);
    }
}

/*
[ 복합 문제 ]
4. 사과의 가격을 5000 ~ 10000 사이의 랜덤값을 가지게 만듭니다.
5. 수확을 할 때 얻는 사과는 3 ~ 5개를 얻게 만듭니다.
6. 수확하여 얻은 사과의 전체 가격을 산출해봅시다.
* 클래스 써도 되고 안써도 됩니다.
*/