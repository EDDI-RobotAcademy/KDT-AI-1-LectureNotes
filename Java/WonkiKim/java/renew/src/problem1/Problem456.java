package problem1;

import java.util.ArrayList;
import java.util.List;

public class Problem456 {
    public static void main(String[] args) {
        final int MAXAPPLE = 5;
        final int MINAPPLE = 3;
        int numberOfApple = (int) (Math.random() * (MAXAPPLE -MINAPPLE +1)) +MINAPPLE;

        List<Apple> appleList = new ArrayList<>();
        //5
        for(int i=0; i<numberOfApple; i++) {
            appleList.add(new Apple());
        }

        //6
        int totalValue = 0;
        for(Apple apple: appleList) {
            totalValue += apple.sell();
        }
        System.out.println(totalValue);

    }
}

class Apple {
    final int MIN_PRICE = 5000;
    final int MAX_PRICE = 10000;
    //4
    final int price;

    public Apple() {
         price = (int) (Math.random() * (MAX_PRICE -MIN_PRICE +1)) +MIN_PRICE;
    }
    public int sell() {
        return price;
    }
}