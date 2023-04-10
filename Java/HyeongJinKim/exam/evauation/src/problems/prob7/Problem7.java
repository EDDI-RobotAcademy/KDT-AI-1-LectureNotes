package problems.prob7;

import customLibrary.utility.CustomRandom;

public class Problem7 {
    public static void main(String[] args) {
        final int MIN_CONDITION = 3;
        final int MAX_CONDITION = 20;
        int applePrice = 2000;
        int condition = CustomRandom.generateNumber(MIN_CONDITION, MAX_CONDITION);

        applePrice *= (double) (100 + condition) / 100;
        System.out.println(applePrice);
    }
}

// 7. 사과 가게에서 사과를 1개에 2000원씩 팔고 있습니다.
// 가게 주인 기분에 따라 가격의 변동이 발생합니다.
// 가격 인상률은 3 ~ 20% 정도입니다.
// 이 내용을 적용하여 사과 가격을 출력해주세요.