package test.test04;

import random.CustomRandom;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AppleTest {
    int AppleMin = 3;
    int AppleMax = 5;

    int CoinMin;
    int CoinMax;
    int RandomApple;

    List<Integer>AppleList;
    public AppleTest(int coinMin, int coinMax) {
        CoinMin = coinMin;
        CoinMax = coinMax;

        AppleList = new ArrayList<>();
    }
    public void RandomAppleCost(){
        RandomApple = CustomRandom.generateNumber(AppleMin,AppleMax);
        for (int i = 0; i < RandomApple; i++){
            int AppleCost = CustomRandom.generateNumber(CoinMin,CoinMax);
            System.out.println(AppleCost);
            AppleList.add(AppleCost);
        }
    }
    public int calculateCost(){
        int tmpNumber = 0;
        for (int i = 0; i < AppleList.size(); i++){
            tmpNumber += AppleList.get(i);

        }
        return tmpNumber;
    }
}
