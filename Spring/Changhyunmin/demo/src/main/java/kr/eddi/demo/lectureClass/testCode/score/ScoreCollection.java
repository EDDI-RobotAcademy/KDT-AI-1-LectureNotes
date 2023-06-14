package kr.eddi.demo.lectureClass.testCode.score;

import java.util.ArrayList;
import java.util.List;

public class ScoreCollection {
    final private List<ScoreInterface> scoreList = new ArrayList<>();
    public void add (ScoreInterface scoreInterface) {
        scoreList.add(scoreInterface);
        //평균의 종류가 여러가지 있음
    }
    public int arithmeticMean (){
        //scoreList를 쭉 나열한 이후 mapToInt()를 통해 Integer 값으로 만듬
        //만들 때 사용하는 메서드는 ScoreInterface에 getScore를 사용한다.
        //각각을 Integer로 만들고 sum()을 통해 합산함
        int total = scoreList.stream().mapToInt(ScoreInterface::getScore).sum();

        return total / scoreList.size();
    }
}
