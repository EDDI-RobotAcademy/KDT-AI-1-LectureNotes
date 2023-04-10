package problems.prob7;
/*
7. 사과 가게에서 사과를 1개에 2000원씩 팔고 있습니다. 가게 주인 기분에 따라 가격의 변동이 발생합니다.
가격 인상률은 3 ~ 20% 정도입니다. 이 내용을 적용하여 사과 가격을 출력해주세요.
 */

import customLibrary.Random;

class Apple {
    final static int defaultCost = 2000;
    int reteOfIncrease = 0;
    double finalCost;
    public Apple() {
    }
    public void setReteOfIncrease(int reteOfIncrease) {
        this.reteOfIncrease = reteOfIncrease;
    }
    public int getReteOfIncrease() {
        return reteOfIncrease;
    }
    public double getFinalCost() {
        return finalCost;
    }
    public void setFinalCost(double finalCost) {
        this.finalCost = finalCost;
    }

    public void storekeeperMood(){
        String[] Moods = {"짜증0단계", "짜증1단계", "짜증2단계", "짜증3단계"};
        String storekeeperMood = Moods[Random.randomNumber(Moods.length -1)];

        switch (storekeeperMood) {
            case "짜증0단계": //기본인상률
                break;
            case "짜증1단계":
                int reteOfIncreaseRange1 = Random.randomNumber(3, 7);
                setReteOfIncrease(reteOfIncreaseRange1);
                break;
            case "짜증2단계":
                int reteOfIncreaseRange2 = Random.randomNumber(8, 12);
                setReteOfIncrease(reteOfIncreaseRange2);
                break;
            case "짜증3단계":
                int reteOfIncreaseRange3 = Random.randomNumber(13, 20);
                setReteOfIncrease(reteOfIncreaseRange3);
                break;
        }

        if (storekeeperMood.equals("짜증0단계")) {
            System.out.println("현재 가게 주인은 화가나지 않았습니다. 사과 가격을 인상하지 않습니다.");
        }
        else {
            System.out.printf("현재 가게 주인은 %s 입니다. 사과 가격을 %d%% 인상합니다.%n", storekeeperMood, getReteOfIncrease());
        }
    }

    public void appleCost () {
        storekeeperMood();

        finalCost = defaultCost + (defaultCost * getReteOfIncrease() * 0.01);
        setFinalCost(finalCost);

        System.out.printf("사과의 가격은 %d원 입니다.", (int)(getFinalCost()));

    }
}
public class Problem7 {

    public static void main(String[] args) {

        Apple apple1 = new Apple();
        apple1.appleCost();

    }
}
