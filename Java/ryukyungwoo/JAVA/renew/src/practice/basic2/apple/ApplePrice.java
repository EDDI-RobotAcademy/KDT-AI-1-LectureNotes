package practice.basic2.apple;

import utility.random.CustomRandom;

public class ApplePrice {
        final private int applePriceNumber;
        public ApplePrice (int applePriceMinNumber, int applePriceMaxNumber) {
            this.applePriceNumber = CustomRandom.generateNumber(applePriceMinNumber, applePriceMaxNumber);
            System.out.println(applePriceNumber);
        }

    public int getApplePriceNumber() {
        return applePriceNumber;
    }

    @Override
    public String toString() {
        return "ApplePrice{" +
                "applePriceNumber=" + applePriceNumber +
                '}';
    }
}
