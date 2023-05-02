package basicTest;

import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class FirstProb6 {
    public static void main(String[] args) {

    final int APPLE_NUM_MAX = 5;
    final int APPLE_NUM_MIN = 3;
    final int APPLE_PRICE_MAX = 10000;
    final int APPLE_PRICE_MIN = 5000;
    List<Integer> applePriceList = new ArrayList<>();

        // appleNum을 하나의 값만 뽑으려면 for문을 돌려서는 안된다.
        // for문을 돌리게 되면 하나의 값이아닌 여러개의 값을 뽑게 된다.
        int appleNum = CustomRandom.generateNumber(APPLE_NUM_MIN, APPLE_NUM_MAX);
        System.out.println(appleNum);

        int appleSum = 0;
        // for (int i = 0; i <= appleNum; i++)
        // i <= appleNum 의 = 때문에 appleNum과 applePriceList의 값이 매칭이 안되는 문제발생
        for (int i = 0; i < appleNum; i++) {
            applePriceList.add(CustomRandom.generateNumber(APPLE_PRICE_MIN, APPLE_PRICE_MAX));
            // List에서 합을 구할때 뒤에 get();를 만들어 값을 얻어와야한다.
            appleSum += applePriceList.get(i);
        }

        System.out.println(applePriceList);
        System.out.println(appleSum);
    }
}
