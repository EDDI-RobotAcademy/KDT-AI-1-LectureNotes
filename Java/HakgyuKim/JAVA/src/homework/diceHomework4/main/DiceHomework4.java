package homework.diceHomework4.main;

import homework.diceHomework4.component.Dice;
import homework.diceHomework4.component.Player;
import homework.diceHomework4.component.Score;

import java.util.ArrayList;
import java.util.List;

class DiceGame4 {
    final private int PLAYER_NUM = 2;
    List<Player> playerList = new ArrayList<>();
    public DiceGame4() {
        for (int i = 0; i < PLAYER_NUM; i++) {
            playerList.add(new Player("플레이어" + (i + 1)));
            System.out.println(playerList.get(i));
        }
    }

    private int findTargetPlayerIndex (int currentPlayerIndex) {
        int targetPlayerIndex = 0;

        if (currentPlayerIndex == 0) {
            targetPlayerIndex = 1;
        }
        return targetPlayerIndex;
    }

    private int findSpecialDiceNumber (int playIndex) {
        final int ARRAY_BIAS = 1;
        final int SPECIAL_DICE_INDEX = 3 - ARRAY_BIAS;

        Dice currentPlayerSpecialDice =
                playerList.get(playIndex).getSelectedGameDice(SPECIAL_DICE_INDEX);

        if (currentPlayerSpecialDice == null) {
            return 0;
        }

        int currentPlayerSpecialDiceNumber =
                currentPlayerSpecialDice.getDiceNumber();

        return currentPlayerSpecialDiceNumber;
    }

    public void playGame() {
        final int STEAL = 1;
        final int BUFF = 3;
        final int DEATH = 4;

        final int STEAL_SCORE = 3;
        final int BUFF_SCORE = 2;
        final int DEATH_SCORE = -1;

        for (int i = 0; i < PLAYER_NUM; i++) {
            int currentPlayerSpecialDiceNum = findSpecialDiceNumber(i);

            if (currentPlayerSpecialDiceNum == 0) {
                continue;
            }

            int targetPlayerIndex = findTargetPlayerIndex(i);

            Score targetPlayerScore =
                    playerList.get(targetPlayerIndex).getScore();

            Score currentPlayerScore =
                    playerList.get(i).getScore();

            switch (currentPlayerSpecialDiceNum) {
                case STEAL:
                    targetPlayerScore.takeScore(currentPlayerScore, STEAL_SCORE);
                    break;

                case BUFF:
                    currentPlayerScore.addScore(BUFF_SCORE);
                    break;

                case DEATH:
                    currentPlayerScore.loseAll(DEATH_SCORE);
                    break;
            }
        }
    }

    public void printResult () {
        for (int i = 0; i < PLAYER_NUM; i++) {
            System.out.println(playerList.get(i));
        }
    }

    public void checkWinner() {
        Score firstPlayerScore = playerList.get(0).getScore();
        Score secondPlayerScore = playerList.get(1).getScore();

        if (firstPlayerScore.getTotalScore() > secondPlayerScore.getTotalScore()) {
            System.out.println("승자는: " + playerList.get(0).getName());
        } else if (secondPlayerScore.getTotalScore() > firstPlayerScore.getTotalScore()) {
            System.out.println("승자는: " + playerList.get(1).getName());
        } else {
            System.out.println("무승부");
        }
    }

}

public class DiceHomework4 {
    public static void main(String[] args) {
        DiceGame4 game = new DiceGame4();
        game.playGame();
        game.printResult();
        game.checkWinner();

    }
}
