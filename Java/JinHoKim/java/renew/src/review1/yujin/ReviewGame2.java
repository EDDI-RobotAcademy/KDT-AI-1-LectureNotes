package review1.yujin;

import java.util.ArrayList;
import java.util.List;

public class ReviewGame2 {
    final private int MAX_DICE = 4;
    List<ReviewDice2> diceList = new ArrayList<>();
    private int diceSum = 0;
    private ReviewScore2 score;

    public ReviewGame2() {
        for (int i = 0; i < MAX_DICE; i++) {
            diceList.add(new ReviewDice2());
            diceSum += diceList.get(i).diceNumber;
        }

        // 점수를 관리하는 score 객체를 별도로 만들었습니다.
        // 그리고 diceSum이라는 합산 값을 입력으로 전달합니다.

        // 클래스 내부에 또 다른 클래스를 배치한다면
        // 아래와 같은 형태로 생성자에서 초기화 해주거나
        // 혹은 특정 조건을 만족하는 상황에서
        // 초기화(생성자 호출)하는 방식을 취하면 됩니다.
        score = new ReviewScore2(diceSum);
    }

    public void checkWin() {
        score.checkWinByScore();
    }

    @Override
    public String toString() {
        return "ReviewGame2{" +
                "diceList=" + diceList +
                ", diceSum=" + diceSum +
                '}';
    }


}
