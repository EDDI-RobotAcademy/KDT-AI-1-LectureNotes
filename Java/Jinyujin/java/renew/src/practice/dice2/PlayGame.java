package practice.dice2;

import java.util.ArrayList;
import java.util.List;

// 4개 주사위 굴리는 클래스
// 주사위 합 구하기
// 합이 3 혹은 4의 배수가 되면 승리

// 스코어 클래스에서 만든 정보 가져오기 - 승패 if문
// 스코어 클래스에서 만든 승패 if 문을 가져오려면 일단 객체 생성
//
public class PlayGame {
    final private int DICE_COUNT = 4;
    final private List<Dice2> diceList = new ArrayList<>();
    int diceSum = 0;

    private Dice2Score score;

    public PlayGame() {
        for (int i = 0; i < DICE_COUNT; i++) {
            diceList.add(new Dice2());
            diceSum += diceList.get(i).getDiceNumber();
        }
        score = new Dice2Score(diceSum); // 매개변수 활용...!
    }

    public void showResult() {
        score.decideWinLose();
    }

    @Override
    public String toString() {
        return "PlayGame{" +
                "diceList=" + diceList +
                ", diceSum=" + diceSum +
                '}';
    }
}
