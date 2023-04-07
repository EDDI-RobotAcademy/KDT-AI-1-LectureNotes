package 주사위_5번_문제.finalDice.player;

import 주사위_5번_문제.finalDice.dice.RefactorDice;
import 주사위_5번_문제.finalDice.score.RefactorScore;

import java.util.ArrayList;
import java.util.List;

public class RefactorDiceGamePlayer implements Comparable<RefactorDiceGamePlayer> {
    final private int MAX_DICE_NUM = 3;
    final private String name;
    final private List<RefactorDice> diceList = new ArrayList<>();
    // RefactorDice 클래스를 받는 diceList
    final private RefactorScore gameScore;

    public RefactorDiceGamePlayer(String name) {
        this.name = name;

        int diceNumberSum = rollEveryDicesIfWeCan();
        gameScore = new RefactorScore(diceNumberSum); // 생성자

    } // 플레이어 클래스에는 이름과 주사위 숫자 합, 이 합을 인자로 갖는 스코어 생성자가 있다.

    private int rollEveryDicesIfWeCan() {
        final int FIRST_DICE_INFO = 0;
        final int DECISION_EVEN = 2;
        final int ODD = 1;

        int diceNumberSum = 0;

        for (int i = 0; i < MAX_DICE_NUM; i++) { // 주사위 갯수(3) 만큼 돌릴꺼임
            diceList.add(new RefactorDice()); // 주사위 클래스에서 만든 숫자(1 ~ 6)를 넣어줄꺼임

            diceNumberSum += diceList.get(i).getDiceNumber(); // 그리고 세번 돌린거 값을 Sum 해줘서 변수에 입력

            if (diceList.get(FIRST_DICE_INFO).getDiceNumber() % DECISION_EVEN == ODD) {
                // 만약에 첫번째 주사위가 홀수라면
                break;
            }
        }

        return diceNumberSum;
    }

    public RefactorDice getSelectedGameDice(int index) {
        if (diceList.size() > index) { // 만약 주사위 크기가 index보다 크면
                                        // ex) 3이면 2 보다 크고, 1이면 2 보다 작고.
                                        // 결국 세번 돌리냐 한번 돌리냐 물어보는거.
            return diceList.get(index);
        } // 2번째 주사위 리턴
        return null; // 없으면 X
    }

    public RefactorScore getGameScore() {
        return gameScore;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", gameDiceList=" + diceList +
                ", gameScore=" + gameScore +
                '}';
    }

    @Override
    public int compareTo(RefactorDiceGamePlayer otherPlayer) {
        final int otherPlayerTotalScore = otherPlayer.getGameScore().getTotalScore();
        final int currentPlayerTotalScore = this.getGameScore().getTotalScore();

        if (otherPlayerTotalScore < currentPlayerTotalScore) {
            return 100; // 만약 현재 플레이어 점수가 상대 점수보다 크면 양의 정수 반환
        } else if (otherPlayerTotalScore > currentPlayerTotalScore) {
            return 0; // 만약 현재 플레이어 점수가 상대 점수보다 작으면 음의 정수 반환
        }

        return 50;
    }
}