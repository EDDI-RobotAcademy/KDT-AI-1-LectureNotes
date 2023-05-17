package finalDice.player;

import finalDice.dice.RefactorDice;
import finalDice.score.RefactorScore;
import java.util.ArrayList;
import java.util.List;

// 같은 타입의 인스턴스를 서로 비교해야만 하는 클래스들은 모두 Comparable인터페이스를 구현
// Comparable 인터페이스를 쓰려면 compareTo메소드를 구현해야한다.
// Comparable은 자기 자신과 매개변수 객체를 비교하는 것
// class RefactorDiceGamePlayer 와 Comparable <RefactorDiceGamePlayer> 를 비교
public class RefactorDiceGamePlayer implements Comparable <RefactorDiceGamePlayer> {
    final private int MAX_DICE_NUM = 3;
    final private String name;
    final private List<RefactorDice> diceList = new ArrayList<>();
    final private RefactorScore gameScore;
    public RefactorDiceGamePlayer(String name) {
        this.name = name;

        int diceNumberSum = rollEveryDicesIfWeCan();
        gameScore = new RefactorScore(diceNumberSum);
    }
    private int rollEveryDicesIfWeCan() {
        final int FIRST_DICE_INFO = 0;
        final int DECISION_EVEN = 2;
        final int ODD = 1;

        int diceNumberSum = 0;

        for (int i = 0; i < MAX_DICE_NUM; i++) {
            diceList.add(new RefactorDice());
            diceNumberSum += diceList.get(i).getDiceNumber();
            if (diceList.get(FIRST_DICE_INFO).getDiceNumber()
                    % DECISION_EVEN == ODD) { // 첫번째 주사위의 숫자 나누기 2 = 1
                break;                        // 홀수이기 때문에 멈춤
            }
        }
        return diceNumberSum;                 // 합산한 숫자
    }
    public RefactorDice getSelectedGameDice(int index) {
        if (diceList.size() > index) {
            return diceList.get(index);
        }
        return null;
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

    // compareTo() 메소드가 객체를 비교할 기준을 정의해주는 부분
    // 작성법은 compareTo(비교할 클래스의 이름 매개변수)
    @Override
    public int compareTo(RefactorDiceGamePlayer otherPlayer) {
        final int otherPlayerTotalScore = otherPlayer.getGameScore().getTotalScore();
        final int currentPlayerTotalScore = this.getGameScore().getTotalScore();

        if (otherPlayerTotalScore < currentPlayerTotalScore) {
            return 1;
        } else if (otherPlayerTotalScore > currentPlayerTotalScore) {
            return -1;
        }

        return 0;
    }
}
