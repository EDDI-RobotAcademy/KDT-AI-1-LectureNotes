package homework3.diceExampleSol.main;


import homework3.diceExampleSol.component.Dice;
import homework3.diceExampleSol.component.Player;
import homework3.diceExampleSol.component.Score;

class Game {
    final private int PLAYER_NUM = 2;
    final private Player[] playerArray = new Player[PLAYER_NUM];

    public Game() {
        for (int i = 0; i < PLAYER_NUM; i++) {
            playerArray[i] = new Player("Player" + (i + 1));
            System.out.println(playerArray[i]);
        }
    }

    private int findTargetPlayerIndex(int currentPlayerIndex) {
        int targetPlayerIndex = 0;

        if (currentPlayerIndex == 0) {
            targetPlayerIndex = 1;
        }
        return targetPlayerIndex;
    }

    private int findSpecialDiceNumber(int playerIndex) {

        final int ARRAY_BIAS = 1;
        final int SPECIAL_DICE_INDEX = 3 - ARRAY_BIAS;

        Dice currentPlyerSpectialDice =
                playerArray[playerIndex].getSelectedDice(SPECIAL_DICE_INDEX);

        if (currentPlyerSpectialDice == null) {return 0;}

        int currentPlayerSpecialDiceNumber =
                currentPlyerSpectialDice.getDiceNumber();

        return currentPlayerSpecialDiceNumber;
    }

    public void playGame() {

        final int STEAL = 1;
        final int STEAL_SCORE = 3;
        final int BUFF = 3;
        final int BUFF_SCORE = 2;
        final int DEATH = 4;
        final int DEATH_SCORE = -1;

        for (int i = 0; i < PLAYER_NUM; i++) {
            int currentPlayerSpecialDiceNumber = findSpecialDiceNumber(i);


            Score targetPlayerScore =
                    playerArray[findTargetPlayerIndex(i)].getScore();
            Score currentPlayerScore =
                    playerArray[i].getScore();

            switch (currentPlayerSpecialDiceNumber) {
                case STEAL:
                    targetPlayerScore.takeScore(currentPlayerScore, STEAL_SCORE);
                    break;
                case BUFF:
                    currentPlayerScore.addScore(BUFF_SCORE);
                    break;
                case DEATH:
                    currentPlayerScore.loseAll(DEATH_SCORE);
                    break;
                default:
                    break;
            }

        }
    }

    public void printResult() {
        for(int i=0; i< PLAYER_NUM; i++) {
            System.out.println(playerArray[i]);
        }
    }

    public void checkWinner() {
        Score firstPlayerScore = playerArray[0].getScore();
        Score secondPlayerScore = playerArray[1].getScore();

        if (firstPlayerScore.getTotalScore() > secondPlayerScore.getTotalScore()){
            System.out.println("winner: "+ playerArray[0].getName());
        } else {
            System.out.println("winner: "+ playerArray[1].getName());

        }
    }


}

public class DiceGame {
    public static void main(String[] args) {
        Game game = new Game();
        game.playGame();
        game.printResult();
        game.checkWinner();
    }
}
