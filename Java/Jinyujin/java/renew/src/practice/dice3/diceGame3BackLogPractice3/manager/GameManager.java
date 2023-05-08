package practice.dice3.diceGame3BackLogPractice3.manager;

import practice.dice3.diceGame3BackLogPractice3.dice.Dice;
import practice.dice3.diceGame3BackLogPractice3.player.Player;
import practice.dice3.diceGame3BackLogPractice3.score.GameScore;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    // 생성자를 만드는 것은 저 클래스를 불렀을 때 무조건 일어나야 하는 일들을 생성자에 해주는 것
    List<Player> playerList = new ArrayList<>();

    public GameManager() {
        for (int i = 0; i < 2; i++) {
            playerList.add(new Player("플레이어" + (i+1)));
            System.out.println(playerList.get(i));
        }
    }

    public int findThirdDiceNumber(int playerIdx) {

        final int thirdDiceIdx = 2;

        Dice currentPlayerThirdDice = playerList.get(playerIdx).needToSelectDice(thirdDiceIdx);

        int currentPlayerThirdDiceNumber = currentPlayerThirdDice.getDiceNumber();

        return currentPlayerThirdDiceNumber;
    }

    public int findCurrentPlayerIdx(int targetPlayerIdx) {

        int currentPlayerIdx = 0;

        if (currentPlayerIdx == 1){
            targetPlayerIdx = 0;
        }
        return currentPlayerIdx;
    }

    public void playGame() {

        final int STEAL = 1;
        final int BUFF = 3;
        final int DEATH = 4;

        final int STEAL_SCORE = 3;
        final int BUFF_SCORE = 2;
        final int DEATH_SCORE = -777;

        for (int i = 0; i < 2; i++) {

            int currentPlayerIdx = findCurrentPlayerIdx(i);

            int currentThirdDiceNumber = findThirdDiceNumber(currentPlayerIdx);

            if (currentThirdDiceNumber == 0) {
                continue;
            }

            GameScore currentPlayerScore = playerList.get(currentPlayerIdx).getGameScore();
            GameScore targetPlayerScore = playerList.get(i).getGameScore();

            switch (currentThirdDiceNumber) {
                // case 3이라면 buff + 2
                case BUFF:
                    currentPlayerScore.addScore(BUFF_SCORE);
                    break;

                case DEATH:
                    currentPlayerScore.deathScore(DEATH_SCORE);
                    break;

                case STEAL:
                    currentPlayerScore.stealScore(targetPlayerScore, STEAL_SCORE);
                    break;
            }
        }
    }
}
