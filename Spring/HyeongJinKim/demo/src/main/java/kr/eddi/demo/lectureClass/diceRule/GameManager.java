package kr.eddi.demo.lectureClass.diceRule;

import kr.eddi.demo.lectureClass.diceRule.player.Player;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    final private int PLAYER_NUM = 2;
    final private List<Player> playerList = new ArrayList<>();

    public GameManager() {
        for (int i = 0; i < PLAYER_NUM; i++) {
            playerList.add(new Player("플레이어" + (i + 1)));
        }
    }

    private int findSpecialDiceNumber (int playerIndex) {
        final int ARRAY_BIAS = 1;
        final int SPECIAL_DICE_INDEX = 3 - ARRAY_BIAS;

        Dice currentPlayerSpecialDice =
                playerList.get(playerIndex).getSelectedGameDice(SPECIAL_DICE_INDEX);

        if (currentPlayerSpecialDice == null) { return 0; }

        return currentPlayerSpecialDice.getDiceNumber();
    }
    public List<Player> playGame() {
        final int STEAL = 1;
        final int BUFF = 3;
        final int DEATH = 4;
        final int STEAL_SCORE = 3;
        final int BUFF_SCORE = 2;
        final int DEATH_SCORE = -100;
        for (int i = 0; i < PLAYER_NUM; i++) {
            int currentPlayerSpecialDiceNumber = findSpecialDiceNumber(i);
            if (currentPlayerSpecialDiceNumber == 0) { continue; }
            GameScore currentPlayerScore =
                    playerList.get(i).getGameScore();

            switch (currentPlayerSpecialDiceNumber) {
                case STEAL:
                    for (int j = 0; j < playerList.size(); j++){
                        playerList.get(j).getGameScore().
                                takeScore(playerList.get(j).getGameScore(), STEAL_SCORE);
                    }
                    currentPlayerScore.addScore(STEAL_SCORE * PLAYER_NUM);
                    break;
                case BUFF:
                    currentPlayerScore.addScore(BUFF_SCORE);
                    break;

                case DEATH:
                    currentPlayerScore.loseAll(DEATH_SCORE);
                    break;
            }
        }
        return playerList;
    }
}