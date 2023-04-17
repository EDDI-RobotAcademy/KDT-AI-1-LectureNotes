package finalDice.player;

import finalDice.dice.RefactorDice;
import finalDice.score.RefactorScore;

import java.util.ArrayList;
import java.util.List;

public class DiceGamePlayer {
    final private int MAX_DICE_NUM = 3;
    final private String name;
    final private List<RefactorDice> diceList = new ArrayList<>();
    final private RefactorScore gameScore;

    public DiceGamePlayer(String name) {
        this.name = name;

        int diceNumberSum = rollEveryDiceIfWeCan();
        gameScore = new RefactorScore(diceNumberSum);
    }

    // DiceGamePlayer 생성자에 rollEveryDiceIfWeCan을 넣고
    // 매서드를 생성해준다.
    // 첫번째 주사위를 굴리는데 홀수인지 짝수인지 판정한다.
    // 홀수라면 멈추고 주사위의 합을 구해야한다.
    // 따라서 이 안에 주사위의 합을 출력해줄 코드를 넣어야한다.
    private int rollEveryDiceIfWeCan() {
        final int FIRST_DICE_INFO = 0;
        final int DECISION_EVEN = 2;
        final int ODD = 1;

        int diceNumberSum = 0;

        // 세개의 주사위를 돌리는 for문
        for (int i = 0; i < MAX_DICE_NUM; i++) {
            // diceList는 랜덤한주사위를 가져야해
            diceList.add(new RefactorDice());
            // .getDiceNumberSum()은 RefactorDice클래스안에 getter로 생성되있음
            // 여기서 getDiceNumber는 랜덤한주사위값을 가진
            // RefactorDice에서 getter로 생성된 매서드이다.
            diceNumberSum += diceList.get(i).getDiceNumber();

            // 만약 첫번째로 돌린 주사위가 홀수라면 멈춰라
            if (diceList.get(FIRST_DICE_INFO).getDiceNumber() % DECISION_EVEN == ODD) {
                break;
            }
        }
        // 홀수판정으로 인해 주사위 굴리기가 첫번째로 끝나는경우
        // 최종적으로 주사위의 합을 구하기 위해 작성해놓은 코드
        return diceNumberSum;              // 1번째 조건, 주사위의 값, 주사위의 합
    }

    // DiceGameManager 에 세번째 조건을 만들기 위해서 생성했음
    // 자동적으로 이 부분에 매서드가 생성됨
    // 매개변수를 index 로 수정해줬음
    // 이 함수는 주어진 인덱스에 해당하는 객체가 리스트에 있는 경우에만 반환하며,
    // 그렇지 않은 경우에는 null을 반환
    public RefactorDice getSelectedGameDice(int index) {
        if (diceList.size() > index) {
            return diceList.get(index);
        }
        return null;
    }

    // 이름과 스코어를 다른 클래스로 가져가기 위해 getter를 생성
    public String getName() {
        return name;
    }

    public RefactorScore getGameScore() {
        return gameScore;
    }

    @Override
    public String toString() {
        return "DiceGamePlayer{" +
                "name='" + name + '\'' +
                ", diceList=" + diceList +
                ", gameScore=" + gameScore +
                '}';
    }

    // 주사위를 세번 돌리는 것과 첫번째 조건을 DiceGamePlayer에 생성
    // 나머지 조건은 Manager에 생성

    // 세 번째 돌리는 조건 주사위는 여기에 매서드를 생성했음
}