package examPractice;

import utility.random.CustomRandom;

// 7. 사과 가게에서 사과를 1개에 2000원씩 팔고 있습니다.
// 가게 주인 기분에 따라 가격의 변동이 발생합니다.
// 가격 인상률은 3 ~ 20% 정도입니다.
// 이 내용을 적용하여 사과 가격을 출력해주세요.
public class Prob7 {
    public static void main(String[] args) {
        final int appleCost = 2000;
        final float increaseRate = CustomRandom.generateNumber(3, 20)/100f;

        System.out.println("인상률: " + increaseRate);
        System.out.println("인상된 사과 가격:  " + appleCost * (1 + increaseRate));
    }
}
