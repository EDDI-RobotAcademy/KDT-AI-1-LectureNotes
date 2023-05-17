package com.example.demo.lectureClass.testCode.score;

import java.util.ArrayList;
import java.util.List;

public class ScoreCollection {

    final private List<ScoreInterface> scoreList = new ArrayList<>();

    public void add (ScoreInterface scoreInterface) {
        scoreList.add(scoreInterface);
    }

    public int arithmeticMean () {
        // scoreList 를 쭉 나열한 이후 mapToInt() 를 통해 Integer 값으로 만듬
        // 만들 때 사용하는 매서드는 ScoreInterface 에 있는 getScore() 을 사용함
        // 각각을 Integer 로 만들고 sum() 을 통해 합산함
        int total = scoreList.stream().mapToInt(ScoreInterface::getScore).sum();

        return total / scoreList.size();
    }
}
