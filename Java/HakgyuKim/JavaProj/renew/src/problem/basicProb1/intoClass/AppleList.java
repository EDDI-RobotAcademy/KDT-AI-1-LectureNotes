package problem.basicProb1.intoClass;

import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class AppleList {
    final int MIN_APPLE = 3;
    final int MAX_APPLE = 5;
    final List<Integer> appleList = new ArrayList<>();
    final int appleCount;
    int applePriceSum = 0;
    public AppleList() {
        appleCount = CustomRandom.generateNumber(MIN_APPLE, MAX_APPLE);
        for (int i = 0; i < appleCount; i++) {
            appleList.add(new Apple().getApplePrice());
            applePriceSum += appleList.get(i);
        }
    }

    public void getAppleList() {
        System.out.println(appleList);
    }

    public void getAppleTotalCost() {
        System.out.println(applePriceSum);
    }
}
