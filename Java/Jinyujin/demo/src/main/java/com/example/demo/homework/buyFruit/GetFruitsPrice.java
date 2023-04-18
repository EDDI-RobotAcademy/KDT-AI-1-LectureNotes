package com.example.demo.homework.buyFruit;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class GetFruitsPrice {
    final private int APPLE_PRICE = 2000;
    final private int WATERMELON_PRICE = 10000;
    final private int appleCount;
    final private int watermelonCount;

    public GetFruitsPrice(int appleCount, int watermelonCount) {
        this.appleCount = appleCount;
        this.watermelonCount = watermelonCount;
    }

    public int calculatePriceSum() {
        int priceSum = (APPLE_PRICE * appleCount) +
                (WATERMELON_PRICE * watermelonCount);

        return priceSum;
    }

}
