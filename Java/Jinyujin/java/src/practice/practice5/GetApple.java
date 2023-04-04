package practice.practice5;

import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class GetApple {

    public int getGetApple() {
        return getApple;
    }

    private int getApple;
    List<ApplePrice> applePriceList = new ArrayList<>();

    final private int MIN_APPLE = 3;
    final private int MAX_APPLE = 5;

    public int getPriceSum() {
        return priceSum;
    }

    private int priceSum = 0;

    public GetApple() {
        // 수확할 때 얻는 사과는 3~5개
        getApple = CustomRandom.generateNumber(MIN_APPLE, MAX_APPLE);

        // 가격은 수확한 사과의 양에 따라 각각 생성되어야 함 - 리스트 필요
        for (int i = 0; i < getApple; i++) {
            applePriceList.add(new ApplePrice());
            priceSum += applePriceList.get(i).getApplePrice();
        }
    }

    @Override
    public String toString() {
        return "GetApple{" +
                "getApple=" + getApple + '\n' +
                ", applePriceList=" + applePriceList + '\n' +
                ", priceSum=" + priceSum +
                '}';
    }
}
