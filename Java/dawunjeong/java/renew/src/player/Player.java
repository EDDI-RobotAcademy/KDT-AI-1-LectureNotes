package player;

import game.Dice;
import game.GameScore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Player(플레이어)에게 필요한게 뭐지 ?
public class Player {
    final private int MAX_DICE_NUM = 3;
    final private String name;
    // 1. 아래 배열을 리스트로 바꾸기
    // final private Dice[] gameDices = new Dice[MAX_DICE_NUM];
    final private List<Dice> gameDiceList = new ArrayList<>();
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

        int diceNumberSum = 0;

        for (int i = 0; i < MAX_DICE_NUM; i++) {
            // 2.
            // gameDices[i] = new Dice();
            gameDiceList.add(new Dice());

            // 3.
            // diceNumberSum += gameDices[i].getDiceNumber();
            diceNumberSum += gameDiceList.get(i).getDiceNumber();

            // 4.
            // if (gameDices[FIRST_DICE_INFO].getDiceNumber() %
            if (gameDiceList.get(FIRST_DICE_INFO).getDiceNumber() %
                    DECISION_EVEN == ODD) {
                break;
            }
        }

        return diceNumberSum;
    }

    public Dice getSelectedGameDice(int index) {
        // 오류 발생 원인 부분!!!
        if(gameDiceList.size() > index) {
            // 5.
            // return gameDices[index];
            return gameDiceList.get(index);
        }
        return null;
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
                ", gameDiceList=" + gameDiceList +
                ", gameScore=" + gameScore +
                '}';
    }
}