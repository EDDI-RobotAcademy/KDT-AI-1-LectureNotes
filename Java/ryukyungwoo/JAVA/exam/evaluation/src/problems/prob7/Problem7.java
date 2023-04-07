package problems.prob7;

import customLibrary.customRandom.CustomRandom;

class ApplePrice {
    final private double ORIGIN_APPLE_PRICE = 2000;
    final private double FLOW_PERCENTAGE_MAX = 20;
    final private double FLOW_PERCENTAGE_MIN = 3;
    private double currentApplePrice;
    public ApplePrice () {
        this.currentApplePrice = ORIGIN_APPLE_PRICE + (ORIGIN_APPLE_PRICE * (double) (Math.random() * (FLOW_PERCENTAGE_MAX - FLOW_PERCENTAGE_MIN + 1) + FLOW_PERCENTAGE_MIN)) * 1/100;
                //(int) (Math.random() * (max - min + 1)) + min;
    }

    public double getCurrentApplePrice() {
        return currentApplePrice;
    }

    @Override
    public String toString() {
        return "ApplePrice{" +
                "currentApplePrice=" + currentApplePrice +
                '}';
    }
}

public class Problem7 {
    public static void main(String[] args) {
        System.out.println(new ApplePrice().getCurrentApplePrice());

    }
}
