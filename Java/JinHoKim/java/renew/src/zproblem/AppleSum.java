package zproblem;

import java.util.ArrayList;
import java.util.List;

public class AppleSum {
    public static void main(String[] args) {
        Apple apple = new Apple();
        apple.applePriceGet();
        apple.appleHarvest();

        List<Integer> appleTotalPrice = new ArrayList<>();
        appleTotalPrice.add(apple.applePriceGet());
        for (int i = 0; i < appleTotalPrice.size(); i++) {

        }
    }
}
