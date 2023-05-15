package kr.eddi.demo.testCode.score;

import java.util.ArrayList;
import java.util.List;

public class ScoreCollection {
    final private List<ScoreInterface> scoreList =new ArrayList<>();

    public void  add (ScoreInterface scoreInterface){
        scoreList.add(scoreInterface);
    }
    //평균의 종류가 여러가지 있음 (가장 기본형태인 산술 평균 -더해서 개수 나누기)
    public int arithmeticMean(){
        // scoreList를 쭉 나열한 이후 mapToInt()를 통해 Integer 값으로 만듬
        // 만들 때 사요하는 매서드는 ScoreInterface에 있는 getScoretkdydgka
        // 각각을 Integerㄹ 만들고 sum()을 통해 합산함
        int total = scoreList.stream().mapToInt(ScoreInterface::getScore).sum();

        return total / scoreList.size();
    }
}