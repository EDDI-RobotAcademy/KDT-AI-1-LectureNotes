package homework.homework7.randomApple;

import utility.random.CustomRandom;

import java.util.ArrayList;

public class AppleList {

    ArrayList<Apple> apples;
    int allApplesCost;

    public AppleList() {
    }
    public void setApples(ArrayList<Apple> apples) {
        this.apples = apples;
    }
    public ArrayList<Apple> getApples() {
        return apples;
    }
    public void setAllApplesCost(int allApplesCost) {
        this.allApplesCost = allApplesCost;
    }


    void takeApple() {
        int takenApple_Min = 3;
        int takenApple_Max = 5;
        int takenAppleRandomCount = CustomRandom.generateNumber(takenApple_Min, takenApple_Max);

        ArrayList<Apple> takenApples = new ArrayList<>();
        for (int i = 0; i < takenAppleRandomCount; i++) {
            takenApples.add(new Apple());
        }
        setApples(takenApples);
    }

    void sumApplesCost() {
        int sum = 0;
        for (int i = 0; i < apples.size(); i++) {
            sum += getApples().get(i).getAppleCost();
        }
        setAllApplesCost(sum);
    }

    @Override
    public String toString() {
        return "<<  사과 목록  >>" + '\n' +
                apples + '\n' +
                "전체 사과의 가격은 " + allApplesCost +
                "원입니다.";
    }
}
