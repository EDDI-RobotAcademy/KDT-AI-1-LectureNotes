package kr.eddi.demo.lectureClass.testCode.source;

import java.util.ArrayList;
import java.util.List;

public class ScoreCollection {

    final private List<ScoreInterface> scoreList = new ArrayList<>();

    public void add (ScoreInterface scoreInterface) {
        scoreList.add(scoreInterface);
    }

    // 평균의 종류가 여러가지 있음 (가장 기본적인 산술 평균 - 더해서 개수로 나누기)

    public int arithmeticMean () {
        int total = scoreList.stream().mapToInt(ScoreInterface::getScore).sum();

        return total / scoreList.size();
    }

}
