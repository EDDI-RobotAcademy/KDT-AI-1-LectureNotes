package homework.homework7.randomApple;

import utility.random.CustomRandom;

public class Apple {
    public Apple() {
    }
    int Applecost_Min = 5000;
    int Applecost_Max = 10000;
    int Applecost = CustomRandom.generateNumber(Applecost_Min, Applecost_Max);

    public int getApplecost() {
        return Applecost;
    }

    void takeApple(){
        int appleCount_Min = 3;
        int appleCount_Max = 5;
        int appleCount = CustomRandom.generateNumber(appleCount_Min, appleCount_Max);

        for (int i = 0 ; i<appleCount; i++) {
           Apple apple =  new Apple();
//           apple.getApplecost()
        }
    }

}
