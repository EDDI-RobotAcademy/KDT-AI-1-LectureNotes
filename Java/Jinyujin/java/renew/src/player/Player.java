package player;

import game.dice.Dice;
import game.dice.GameScore;

import java.util.ArrayList;
import java.util.List;

public class Player {
    final private int MAX_DICE_NUM = 3;
    final private String name;
    final private List<Dice> gameRefactorDiceList = new ArrayList<>();
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
            gameRefactorDiceList.add(new Dice());

            diceNumberSum += gameRefactorDiceList.get(i).getDiceNumber();

            if (gameRefactorDiceList.get(FIRST_DICE_INFO).getDiceNumber() %
                    DECISION_EVEN == ODD) {
                break;
            }
        }

        return diceNumberSum;
    }

    public Dice getSelectedGameDice(int index) {
        if (gameRefactorDiceList.size() > index) {
            return gameRefactorDiceList.get(index);
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
                ", name='" + name + '\'' +
                ", gameDiceList=" + gameRefactorDiceList +
                ", gameScore=" + gameScore +
                '}';
    }
}
