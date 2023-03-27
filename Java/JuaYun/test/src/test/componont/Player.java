package test.componont;

import java.util.Arrays;

// Player에게 필요한게 뭐지?
public class Player {
    final private int MAX_DICE_NUM = 3; // 주사위의 갯수가 3개
    final private String name;
    final private GameDice[] gameDices = new GameDice[MAX_DICE_NUM];
    final private GameScore gameScore;

    public Player(String name) {
        this.name = name;

        int diceNumberSum = rollDice();
        gameScore = new GameScore(diceNumberSum);
    }
    private int rollDice() {
        final int FIRST_DICE_INFO = 0;
        final int DECISION_EVEN = 2;
        final int ODD = 1;

        int diceNumberSum = 0; // 0으로 초기화

        for (int i = 0; i < MAX_DICE_NUM; i++) {
            gameDices[i] = new GameDice();
            diceNumberSum += gameDices[i].getDiceNumber();

            if(gameDices[FIRST_DICE_INFO].getDiceNumber() % DECISION_EVEN == ODD) {
                break;
            } // 첫번째 주사위를 굴렸을 때 홀수이기 때문에 멈춤
        }

        return diceNumberSum; // 홀수가 나왔기 때문에 멈추고 점수 합산
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
