package practice.dice3BackLog2.game;

import practice.dice3BackLog2.dice.Dice;
import practice.dice3BackLog2.player.Player;
import practice.dice3BackLog2.score.Score;

import java.util.ArrayList;
import java.util.List;

public class PlayGame {

    final private List<Player> playerList = new ArrayList<>();

    public PlayGame() {
        // 생성자 안만들어줬었음

        final int PLAYER_NUMBER = 2;

        for (int i = 0; i < PLAYER_NUMBER; i++) {
            playerList.add(new Player("플레이어" + (i+1)));
            System.out.println(playerList.get(i));
        }
    }

    public int findThirdDiceNumber(int currentPlayerIdx){

        final int THIRD_DICE_INDEX = 2;

        Dice currentPlayerThirdDice = playerList.get(currentPlayerIdx).needToSelectDice(THIRD_DICE_INDEX);

        if (currentPlayerThirdDice == null) {
            return 0;
        }

        int currentPlayerThirdDiceNumber = currentPlayerThirdDice.getDiceNumber();

        return currentPlayerThirdDiceNumber;
    }

    public int findTargetPlayerIdx(int currentPlayerIdx) {
        int targetPlayerIdx = 0;

        if (targetPlayerIdx == 1) {
             currentPlayerIdx = 0;
        }

        return currentPlayerIdx;
    }

    public void playGame() {

        final int BUFF = 3;
        final int DEATH = 4;
        final int STEAL = 1;

        final int BUFF_SCORE = 2;
        final int DEATH_SCORE = -777;
        final int STEAL_SCORE = 3;

        for (int i = 0; i < playerList.size(); i++) {
            int currentPlayerThirdDiceNumber = findThirdDiceNumber(i);

            Score currentPlayerScore = playerList.get(i).getTotalScore();

            int targetPlayerIdx = findTargetPlayerIdx(i);

            Score talgetPlayerScore = playerList.get(targetPlayerIdx).getTotalScore();

            switch (currentPlayerThirdDiceNumber) {
                case BUFF: currentPlayerScore.addScore(BUFF_SCORE);

                case DEATH: currentPlayerScore.deathScore(DEATH_SCORE);

                case STEAL: currentPlayerScore.stealScore(talgetPlayerScore, STEAL_SCORE);
            }
        }
    }

    @Override
    public String toString() {
        return "PlayGame{" +
                "playerList=" + playerList +
                '}';
    }
}
