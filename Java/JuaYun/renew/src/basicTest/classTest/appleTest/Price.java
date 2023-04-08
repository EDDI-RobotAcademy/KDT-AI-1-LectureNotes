package basicTest.classTest.appleTest;

import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class Price {
    final private int APPLE_PRICE_MAX = 10000;
    final private int APPLE_PRICE_MIN = 5000;
    private List<Integer> applePriceList;
    Apple apple = new Apple();
    int AppleSum = 0;

    public Price() {
        applePriceList = new ArrayList<>();

        // 사과의 숫자에 가격을 할당해주어야하기 때문에 사과클래스에서 사과의갯수를 가져와야함
        for (int i = 0; i < apple.getAppleNum(); i++) {
            // 그리고 applePriceList에 직접 랜덤설정을 해야함
            applePriceList.add(CustomRandom.generateNumber(APPLE_PRICE_MIN,APPLE_PRICE_MAX));
            AppleSum += applePriceList.get(i);
        }
    }

    public List<Integer> getApplePriceList() {
        return applePriceList;
    }

    @Override
    public String toString() {
        return "Price{" +
                "applePriceList=" + applePriceList +
                ", apple=" + apple +
                ", AppleSum=" + AppleSum +
                '}';
    }

    public static void main(String[] args) {
        // 사과클래스는 이미 Price클래스에 선언되있기 때문에 가져오지않아도됨
        // 오히려 사과클래스를 여기에 선언하고 출력하게되면
        // 사과값이 자기혼자 따로도는 일이 발생
        Price price = new Price();

        System.out.println(price);

        // 직접적으로 AppleSum을 가져올 수 없을 때
        // 클래스를 선언하고 클래스의 이름인 price를 앞에 가져다붙여서 선언해야함
        System.out.println("사과의 총합은: " + price.AppleSum);

    }
}
