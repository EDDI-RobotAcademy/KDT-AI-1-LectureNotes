package homework.homework7.randomApple;

import utility.random.CustomRandom;

import java.util.ArrayList;

public class AppleList {

    ArrayList<Apple> apples;
    int applesCostSum;

    public AppleList() {
    }
    public void setApples(ArrayList<Apple> apples) {
        this.apples = apples;
    }
    public ArrayList<Apple> getApples() {
        return apples;
    }
    public void setApplesCostSum(int applesCostSum) {
        this.applesCostSum = applesCostSum;
    }


    public void takeApple() {
        int takenApple_Min = 3;
        int takenApple_Max = 5;
        int takenAppleRandomCount = CustomRandom.generateNumber(takenApple_Min, takenApple_Max);

        ArrayList<Apple> takenApples = new ArrayList<>();
        for (int i = 0; i < takenAppleRandomCount; i++) {
            takenApples.add(new Apple());
        }
        setApples(takenApples);
    }

    public void sumApplesCost() {
        int tmpSum = 0;
        for (int i = 0; i < apples.size(); i++) {
            tmpSum += apples.get(i).getAppleCost();
        }
        setApplesCostSum(tmpSum);
    }

    @Override
    public String toString() {
        return "<<  사과 목록  >>" + '\n' +

                apples + '\n' + '\n' +

                " >> 전체 사과의 가격은 " + applesCostSum +
                "원입니다.";
    }
}
