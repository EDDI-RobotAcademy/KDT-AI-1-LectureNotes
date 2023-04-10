package basicTest.apple;

import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class Price {
    int ApplePriceMax = 10000;
    int ApplePriceMin = 5000;
    List<Integer> ApplePriceList = new ArrayList<>();

    Apple apple = new Apple();

    public Price() {
        for (int i = 0; i < apple.AppleNum; i++) {
            ApplePriceList.add(CustomRandom.generateNumber(ApplePriceMin,ApplePriceMax));
        }
    }

    public int priceSum() {
        int tmpSum = 0;

        for (int i = 0; i < ApplePriceList.size(); i++) {
            tmpSum += ApplePriceList.get(i);
        }
        return tmpSum;
    }

    @Override
    public String toString() {
        return "Price{" +
                "ApplePriceList=" + ApplePriceList +
                ", apple=" + apple +
                '}';
    }
}
