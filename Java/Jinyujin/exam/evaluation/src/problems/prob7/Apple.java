package problems.prob7;

import customLibrary.CustomRandom;

// 사과 가게
// 사과 가격 1개에 2000원
// 가격 변동 발생률: 3 ~ 20%
public class Apple {

    // 일단 원래 가격 선언해보자
    final private float originalApplePrice = 2000;
    // 변동발생률은 어떻게 적용할까?
    // 원래 가격 * (3 ~ 20%)
    // 커스텀랜덤 해보자
    final private int MIN_PERCENT = 3;
    final private int MAX_PERCENT = 20;
    final private int CAN_MAKE_PERCENT = 100;

    public void calculateApplePrice() {

        float changePercentage = CustomRandom.generateNumber(MIN_PERCENT, MAX_PERCENT);
        System.out.println("오늘 사과 인상률은 " +  changePercentage + "% 입니다");

        float changeApplePrice = originalApplePrice * (changePercentage/CAN_MAKE_PERCENT);
        System.out.println("그래서 오늘 사과 가격은 " + (originalApplePrice+ changeApplePrice) + "원 입니다");

    }

}
