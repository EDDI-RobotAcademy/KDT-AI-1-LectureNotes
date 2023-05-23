package problems.prob7;

import problems.CustomRandom;

// 사과 가게에서 사과를 1개에 2000원씩 팔고 있습니다
// 가게 주인 기분에 따라 가격의 변동이 발생합니다.
// 가격 인상률은 3 ~ 20% 정도입니다.
// 이 내용을 적용하여 사과 가격을 출력해주세요.
public class Apple {
    private int applePrice;
    private int priceMin = 2000 + (2000 * 3/100);
    private int priceMax = 2000 + (2000 * 2/10);

    public Apple() {
        applePrice = CustomRandom.generateNumber(priceMin,priceMax);

        System.out.println(applePrice);
    }
}
