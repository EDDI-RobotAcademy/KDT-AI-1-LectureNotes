package practice.apple.AppleReview;

import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class RandomApple {

        final int appleMinCost;
        final int appleMaxCost;
        // 사과의 가격을 매개변수로 하는 생성자 만들기 위한 선언

        final int ACQUIRE_MIN = 3;
        final int ACQUIRE_MAX = 5;
        // 사과 개수 구하기

        int realAcquireNumber; // 진짜로 구한 사과 개수
        List<Integer> appleCostList; // 사과가격 리스트

    public RandomApple(int appleMinCost, int appleMaxCost) {
        this.appleMinCost = appleMinCost;
        this.appleMaxCost = appleMaxCost;

        appleCostList = new ArrayList<>();
    }

    public void acquireApples() {

        realAcquireNumber = CustomRandom.generateNumber(ACQUIRE_MIN, ACQUIRE_MAX);
        // 진짜로 수확한 사과의 수 랜덤으로 찾기

        for (int i = 0; i < realAcquireNumber; i++) {
            int randomAppleCost = CustomRandom.generateNumber(appleMinCost, appleMaxCost);
            System.out.println("사과 가격: " + randomAppleCost);
            // 사과 가격을 랜덤으로 찾고
            // 사과의 수까지 for문을 이용해서 돌림
            // 사과 가격이 얼마인지 출력하고

            appleCostList.add(randomAppleCost);
            // 사과 가격 리스트에 랜덤으로 찾은 사과 가격 추가
        }
    }
    // 이 메서드는 사과를 랜덤으로 찾고
    // 사과 가격도 랜덤으로 찾고
    // 그 가격을 찾은 사과 개수까지 찾아서
    // 사과가격리스트에 추가함
    // 메서드를 실행할 때 한번씩 넣는 것

    public int caculateCost() {
        int tmpSum = 0;

        for (int i = 0; i < appleCostList.size(); i++) {
            tmpSum += appleCostList.get(i);
        }
        return tmpSum;
    } // 이제 tmpSum이라는 이름으로 사과 가격 리스트에 넣은 가격들을 더해줄 것임
      // 나는 리스트에 넣어서 한번에 한다고 애먹었는데
      // 그냥 이렇게 메서드 하나 더 만들 수 있겠구나
      // 좀 더 공부하고 익숙해져서 이렇게 만들어보자
}
