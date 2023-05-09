package com.example.demo.vue.files.testCode.score;

import java.util.ArrayList;
import java.util.List;

public class ScoreCollection {

    final private List<ScoreInterface> scoreList = new ArrayList<>();

    public void add (ScoreInterface scoreInterface) {
        scoreList.add(scoreInterface);
    }

    public int arithmeticMean () {
        int total = scoreList.stream().mapToInt(ScoreInterface::getScore).sum();

        return total / scoreList.size();
    }
}
