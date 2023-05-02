package finalDice.Player;

import finalDice.Dice.RefactorDice;
import finalDice.score.RefactorScore;

import java.util.ArrayList;
import java.util.List;

// implements는 여러개 사용 가능하다. (자바에서 다중상속 대신 사용)
// class가 interface를 사용할 땐 implements를 사용
public class RefactorDiceGamePlayer implements Comparable<RefactorDiceGamePlayer> {
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
            // 랜덤 주사위 값 추가
            diceList.add(new RefactorDice());

            diceNumberSum += diceList.get(i).getDiceNumber();

            // 짝수 홀수 판별 (홀수면 break)
            if (diceList.get(FIRST_DICE_INFO).getDiceNumber() %
                    DECISION_EVEN == ODD) {
                break;
            }
        }

        return diceNumberSum;
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

    // Comparable 인터페이스는 객체를 정렬하는 데 사용되는 메소드인 compareTo() 메소드를 정의
    // 같은 타입의 인스턴스를 서로 비교해야만 하는 클래스들은 모두 Comparable 인터페이스를 구현
    // Comparator 인터페이스는 Comparable 인터페이스와 같이 객체를 정렬하는 데 사용되는 인터페이스입니다.
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
