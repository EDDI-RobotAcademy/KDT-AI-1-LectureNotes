package problems.prob7;
 //사과 가게에서 사과를 1개에 2000원씩 팔고 있습니다. 가게 주인 기분에 따라 가격의 변동이 발생합니다. 가격 인상률은 3 ~ 20% 정도입니다. 이 내용을 적용하여 사과 가격을 출력해주세요.

import customLibrary.utility.random.CustomRandom;

public class Problem7 {
    public static void main(String[] args) {
        int applePrice=2000;
        float plusPriceRate = CustomRandom.generateNumber(3,20) *0.01f;
        int applePriceRandom = applePrice + (int) (applePrice * plusPriceRate);

        System.out.println("사과의 가격변동= "
                +applePriceRandom + " 사과가격 인상률은 (" + plusPriceRate*100 +" %) 입니다." );

    }
}
