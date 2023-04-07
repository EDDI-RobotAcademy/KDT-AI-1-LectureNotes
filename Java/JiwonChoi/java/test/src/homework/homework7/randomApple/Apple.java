package homework.homework7.randomApple;

import utility.random.CustomRandom;

public class Apple {
    int AppleCost_Min = 5000;
    int AppleCost_Max = 10000;
    int AppleCost = CustomRandom.generateNumber(AppleCost_Min, AppleCost_Max);

    public Apple() {
    }
    public int getAppleCost() {
        return AppleCost;
    }

    @Override
    public String toString() {
        return AppleCost +
                "원";
    }
}
