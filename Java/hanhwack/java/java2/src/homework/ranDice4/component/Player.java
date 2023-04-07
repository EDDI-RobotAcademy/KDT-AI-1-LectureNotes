package homework.ranDice4.component;

import java.util.Arrays;

public class Player {
    //주사위를 돌리는 횟수
    final private int MAX_DICE_NUM = 3;
    // 플레이어 명
    final private String name;
    // 돌린 주사위를 저장할 배열을 생성
    final GameDice[] gameDices = new GameDice[MAX_DICE_NUM];
    final private GameScore gameScore;

    public Player(String name) {
        this.name  = name ;

        int diceNumberSum = rollDice();
        gameScore = new GameScore(diceNumberSum);
    }
    private int rollDice() {
        //초기 주사위정보
        final int FIRST_DICE_INFO = 0;
        // 짝수일경우
        final int DECISION_EVEN = 2;
        // 홀수일 경우
        final int ODD = 1;

        int diceNumberSum = 0;

        for (int i = 0; i < MAX_DICE_NUM; i++) {
            gameDices[i] = new GameDice();

            diceNumberSum += gameDices[i].getDiceNumber();

            // 홀수라면 brak를 통해 주사위 던지기를 끝낸다
            if (gameDices[FIRST_DICE_INFO].getDiceNumber() %
                    DECISION_EVEN == ODD) {
                break;
            }
        }

        return diceNumberSum;
    }

    public GameDice getSelectedGameDice(int index) {
        return gameDices[index];
    }

    public GameScore getGameScore() {
        return gameScore;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", gameDices=" + Arrays.toString(gameDices) +
                ", gameScore=" + gameScore +
                '}';
    }

}
