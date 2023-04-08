package homework.homework7.randomApple.classVersion;

import utility.random.CustomRandom;

import java.util.ArrayList;

public class RandomApple {
    int minCost = 5000;
    int maxCost = 10000;
    int minTakeApplesNum = 3;
    int maxTakeApplseNum = 5;

    public RandomApple() {  // 생성자
    }

    public ArrayList<Integer> takeApplesAndCost() { //사과를 3~5개 따서 랜덤 가격들을 출력
        ArrayList<Integer> takeApplesAndCostList = new ArrayList<>();
        int takeApplesNum = CustomRandom.generateNumber(minTakeApplesNum, maxTakeApplseNum);

        for (int i = 0; i < takeApplesNum; i++) {
            int appleCost = CustomRandom.generateNumber(minCost, maxCost);
            takeApplesAndCostList.add(appleCost);
        }
        System.out.println(takeApplesAndCostList);

        return takeApplesAndCostList;
    }

    public void applesCostSum (ArrayList<Integer> takeApplesCostList) { //입력한 가격리스트의 합을 출력
        int tmpApplesCostSum = 0;

        for (int i = 0; i < takeApplesCostList.size() ; i++){
            tmpApplesCostSum += takeApplesCostList.get(i);
        }

        System.out.println("사과의 총 가격은 " + tmpApplesCostSum + "원 입니다.");

    }

}
