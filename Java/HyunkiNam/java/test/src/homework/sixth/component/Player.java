package homework.sixth.component;

import java.util.ArrayList;
import java.util.List;

public class Player {

    final String name;
    final int diceNumber;
    final GameScore gameScore;

    List<GameDice> gameDices = new ArrayList<>();

    public Player(String name) {
        this.name = name;
        diceNumber = rollDice();
        gameScore = new GameScore(diceNumber);
    }

    private int rollDice() {
        final int DICE_NUM = 3;

        int scoreSum = 0;

        final int FIRST_DICE_NUM = 0;

        for(int i = 0; i< DICE_NUM; i++){
            gameDices.add(new GameDice());
        }

        if(!evenCheck(FIRST_DICE_NUM)){
            for(int i=1; i<DICE_NUM; i++){
                gameDices.get(i).setDiceNumber(0);
            }
        }

        for(int i=0; i<DICE_NUM; i++){
            scoreSum += gameDices.get(i).getDiceNumber();
        }

        return scoreSum;
    }

    public boolean evenCheck(int FIRST_DICE_NUM){
        final int DECISION_EVEN = 2;
        final int ODD = 1;

        if(gameDices.get(FIRST_DICE_NUM).getDiceNumber() % DECISION_EVEN == ODD){
            return false;
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public List<GameDice> getGameDices() {
        return gameDices;
    }



    public int getDiceNumber() {
        return diceNumber;
    }

    public GameScore getGameScore() {
        return gameScore;
    }
}
