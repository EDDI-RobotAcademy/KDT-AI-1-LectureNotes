package com.example.demo.lectureClass.testCode.score;

import java.util.ArrayList;
import java.util.List;

public class ScoreCollection {
    // 평균 구할 것임
    final private List<ScoreInterface> scoreList = new ArrayList<>();

    public void add (ScoreInterface scoreInterface) {
        scoreList.add(scoreInterface);
    }

    // 평균의 종류가 여러가지 있음 (가장 기본형태인 산술 평균 - 더 해서 개수 나누기)
    public int arithmeticMean () {
        // scoreList를 쭉 나열한 이후 maptoInt()를 통해 Intrger 값으로 만듬
        // 만들 때 사용하는 메서드는 ScoreInterface에 있는 getScore()를 사용함
        // 각각을 Integer로 만들고 sum()을 통해 합산함
        // 요것이 람다 문법이라고 함
        int total = scoreList.stream().mapToInt(ScoreInterface::getScore).sum(); // 합 구하기
        // stream이 리스트를 람다식으로 처리할 수 있도록 지원해줌

        return total / scoreList.size();
    }
}
