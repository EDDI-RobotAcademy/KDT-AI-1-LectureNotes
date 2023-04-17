package test.apple;

import random.CustomRandom;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Apple {
    //가격의 최소, 최대값
    int Min;
    int Max;
    //사과나무 하나에 사과 최소 최대값
    int Apple_Min = 3;
    int Apple_Max = 5;
    //ㄴ사과나무ㄱ
    int RandomApple;
    List<Integer>appleList;
    //List 생성
    public Apple(int min, int max) {
        Min = min;
        Max = max;

        appleList = new ArrayList<>();
        //생성자로 가격의 최소 최대값 부여 + List에  new ArrayList<>(); 부여

    }

    public void RandomCostApple(){
        RandomApple = CustomRandom.generateNumber(Apple_Min, Apple_Max);
        //사과나무 = 랜덤하게 나온다(사과 3개 ~ 5개가)
        for (int i = 0; i < RandomApple; i++){
            //RandomApple 가 List 로 사용됬으면 RandomApple.size()로도 사용됬다.
            int RandomCost = CustomRandom.generateNumber(Min,Max);
            //RandomCost 는 랜덤하게 나온다 (가격의 최소, 최대값 -> 다른 클레스에서 부여한다)
            System.out.println(RandomCost);
            //사과나무에서 나오는 3~5개의 사과들을 / 랜덤한 가격을 부여한다.
            appleList.add(RandomCost);
            //RandomCost 에 나온 숫자들을 appleList 라는 베열에 add 합한다.

        }

    }
    public int calculateCost(){
        int tmpNumber = 0;
        for (int i = 0; i < appleList.size(); i++){
            //
            tmpNumber += appleList.get(i);
        }
        return tmpNumber;
    }
}
