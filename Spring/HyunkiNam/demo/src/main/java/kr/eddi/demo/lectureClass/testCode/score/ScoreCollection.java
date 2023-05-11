package kr.eddi.demo.lectureClass.testCode.score;

import java.util.ArrayList;
import java.util.List;

public class ScoreCollection {
    final private List<ScoreInterface> scoreList = new ArrayList<>();

    public void add(ScoreInterface scoreInterface) {
        scoreList.add(scoreInterface);
    }

    ScoreInterface scoreInterface;

    // 평균의 종류가 여러가지 있음 (가장 기본형태인 산술 평균 - 더 해서 개수 나누기)
    public int arithmeticMean() {
        int total = scoreList.stream().mapToInt(ScoreInterface::getScore).sum();

        return total / scoreList.size();
    }
}