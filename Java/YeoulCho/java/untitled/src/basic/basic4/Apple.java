package basic.basic4;

import utility.random.CustomRandom;

public class Apple {
    int APPLE_MIN = 3;
    int APPLE_MAX = 5;
    int appleCount;

    public int Harvest(){
        appleCount = CustomRandom.generateNumber(APPLE_MIN,APPLE_MAX);
        return appleCount;
    }
}
