package homework.problem.first.classVersion.randomApple;

import utility.random.CustomRandom;
import java.util.ArrayList;
import java.util.List;

public class RandomApple {
    final int appleMinCost;
    final int appleMaxCost;
    final int ACQUIRE_MIN = 3;
    final int ACQUIRE_MAX = 5;
    int realAcquireNumber; //랜덤으로 구한 사과 개수
    List<Integer> appleCostList; //사과의 개수만큼 리스트가 만들어지고, 각 사과의 가격이 들어있다.

    public RandomApple(int appleMinCost, int appleMaxCost) {
        this.appleMinCost = appleMinCost;
        this.appleMaxCost = appleMaxCost;

        appleCostList = new ArrayList<>();
    }

    public void acquiredApples() {
        // 랜덤으로 사과 개수를 구한다.
        realAcquireNumber = CustomRandom.generateNumber(ACQUIRE_MIN, ACQUIRE_MAX);

        // 사과 개수만큼 돌린다.
        for(int i = 0; i < realAcquireNumber; i++){
            // 각 사과 가격을 구한다.
            int randomAppleCost = CustomRandom.generateNumber(appleMinCost, appleMaxCost);
            System.out.println("사과 가격: "+randomAppleCost);

            // 리스트에 추가해준다.
            appleCostList.add(randomAppleCost);
        }
    }

    public int calculateCost(){
        int tmpSum = 0;

        for(int i = 0; i < appleCostList.size(); i++){
            tmpSum += appleCostList.get(i);
        }
        return tmpSum;
    }
}
