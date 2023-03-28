package homework.sixth.component;

import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {

    final String name;
    final int diceNumber;
    final GameScore gameScore;
    final private int DICE_NUM = 3;

    List<Integer> gameDices = new ArrayList<>(Arrays.asList(0,0,0));

    public Player(String name) {
        this.name = name;
        diceNumber = rollDice();
        gameScore = new GameScore(diceNumber);
    }

    private int rollDice() {

        final int MIN = 1;
        final int MAX = 6;

        int scoreSum = 0;

        final int FIRST_DICE_NUM = 0;
        final int DECISION_EVEN = 2;
        final int ODD = 1;

        for(int i=0; i<DICE_NUM; i++){
            int randomValue = CustomRandom.generateNumber(MIN,MAX);
            gameDices.set(i,randomValue);
            scoreSum += randomValue;

            if(gameDices.get(FIRST_DICE_NUM) % DECISION_EVEN == ODD){
                break;
            }
        }

        return scoreSum;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getGameDices() {
        return gameDices;
    }

    public int getDiceNumber() {
        return diceNumber;
    }

    public GameScore getGameScore() {
        return gameScore;
    }
}
