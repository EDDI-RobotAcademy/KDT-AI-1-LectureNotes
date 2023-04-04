package basic.basic4;

import utility.random.CustomRandom;

public class Price {
    int APPLEPRICE_MIN = 5000;
    int APPLEPRICE_MAX = 10000;
    int applePrice;

    public int applePrice(){
        applePrice = CustomRandom.generateNumber(APPLEPRICE_MIN,APPLEPRICE_MAX);
        return applePrice;
    }

    public int applePrice1(){
        applePrice = ((int)(Math.random()*(APPLEPRICE_MAX - APPLEPRICE_MIN +1)) +APPLEPRICE_MIN)/10 * 10;
        return applePrice;

    }
}
