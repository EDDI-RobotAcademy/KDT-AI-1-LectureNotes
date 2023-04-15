package homework.basicProblem.sellingApple;

import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class SetApple {
    private int applePrice;
    private int numberOfApple;
    private int totalIncome;
    List<Integer> applePriceList = new ArrayList<>();

    public SetApple() {
        numberOfApple = CustomRandom.generateNumber(3, 5);
        System.out.println("사과의 개수는 " + numberOfApple);
        for (int i = 0; i < numberOfApple; i++) {
            applePrice = CustomRandom.generateNumber(5000, 10000);
            applePriceList.add(applePrice);
        }
        for (int number: applePriceList) {
            System.out.println("각각 사과의 가격은 " + number);
            totalIncome += number;

        }
        System.out.println("총 판매액은 " + totalIncome);
    }
}
