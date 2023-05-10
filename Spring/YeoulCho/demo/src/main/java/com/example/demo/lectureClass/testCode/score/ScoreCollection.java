package com.example.demo.lectureClass.testCode.score;

import java.util.ArrayList;
import java.util.List;

public class ScoreCollection {
    final private List<ScoreInterface> scoreList = new ArrayList<>();
    public void add(ScoreInterface scoreInterface){
        scoreList.add(scoreInterface);
    }
    //평균의 종류가 여러가지 있음 (가장 기본형태인 산술 평균 - 더해서 개수 나누기)
    public int arithmeticMean(){
        // scoreList를 쭉 나열한 이휴 mapToInt()를 통해 Integer 값으로 만듬
        // 만들때 사용하는 메서드는 ScoreInterface에 있는 getScore()를 사용함
        // 각각을 Integer로 만들고 sum()을 통해 합산함
        int total=scoreList.stream().mapToInt(ScoreInterface::getScore).sum();
        int total2=scoreList.stream().mapToInt(x -> x.getScore()).sum();
        //stream 흐름 scoreList는 score의 list 이걸 mapToInt하면 int의 stream으로 바꿔준다. 어떻게???
        //ScoreInterface의 getScore()를 통해서

        return total2/scoreList.size();

    }

}
