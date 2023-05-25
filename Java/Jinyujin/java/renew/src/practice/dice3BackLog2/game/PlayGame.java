package practice.dice3BackLog2.game;

import practice.dice3BackLog2.dice.Dice;
import practice.dice3BackLog2.player.Player;
import practice.dice3BackLog2.score.Score;

import java.util.ArrayList;
import java.util.List;

public class PlayGame {

    final private List<Player> playerList = new ArrayList<>();
    final private int PLAYER_NUMBER = 2;

    public PlayGame() {
        // 생성자 안만들어줬었음

        for (int i = 0; i < PLAYER_NUMBER; i++) {
            playerList.add(new Player("플레이어" + (i+1)));
            System.out.println(playerList.get(i));
        } // 이 부분도 이따 설명 점..
    }

    public int findThirdDiceNumber(int currentPlayerIdx){

        final int THIRD_DICE_INDEX = 2;

        Dice currentPlayerThirdDice = playerList.get(currentPlayerIdx).needToSelectDice(THIRD_DICE_INDEX);

        if (currentPlayerThirdDice == null) {
            return 0;
        }
        // 첫 번째 주사위가 홀수면 세 번째 주사위가 없으니까 null값이 들어있음
        // 그니까 이걸 처리해줘야 한다

        int currentPlayerThirdDiceNumber = currentPlayerThirdDice.getDiceNumber();

        return currentPlayerThirdDiceNumber;
    }

    public int findTargetPlayerIdx(int currentPlayerIdx) {
        int targetPlayerIdx = 0;

        if (currentPlayerIdx == 0) {
             targetPlayerIdx = 1;
        }

        return targetPlayerIdx;
    }

    public void playGame() {

        final int BUFF = 3;
        final int DEATH = 4;
        final int STEAL = 1;

        final int BUFF_SCORE = 2;
        final int DEATH_SCORE = -777;
        final int STEAL_SCORE = 3;

        for (int i = 0; i < PLAYER_NUMBER; i++) {
            int currentPlayerThirdDiceNumber = findThirdDiceNumber(i);

            int targetPlayerIdx = findTargetPlayerIdx(i);

            Score currentPlayerScore = playerList.get(i).getTotalScore();

            switch (currentPlayerThirdDiceNumber) {
                case BUFF:
                    currentPlayerScore.addScore(BUFF_SCORE);
                    break;

                case DEATH:
                    currentPlayerScore.deathScore(DEATH_SCORE);
                    break;

                case STEAL:
                    Score targetPlayerScore = playerList.get(targetPlayerIdx).getTotalScore();
                    currentPlayerScore.stealScore(targetPlayerScore, STEAL_SCORE);
                    break;
            }
        }
    }

    // 여기서 이제 위에 playGame으로 인해 바뀐 결과들을 새로 출력하도록 할 수 있음
    public void nextToThirdCondition() {
        for (int i = 0; i < PLAYER_NUMBER; i++) {
            System.out.println(playerList.get(i));
        }
    }

    public void checkWin() {

        Score firstPlayerScore = playerList.get(0).getTotalScore();
        Score secondPlayerScore = playerList.get(1).getTotalScore();

        if (firstPlayerScore.getTotalScore() > secondPlayerScore.getTotalScore()) {
            System.out.println("플레이어1 승리!");
        }
        if (firstPlayerScore.getTotalScore() < secondPlayerScore.getTotalScore()){
            System.out.println("플레이어2 승리!");
        }
        if (firstPlayerScore.getTotalScore() == secondPlayerScore.getTotalScore()){
            System.out.println("무승부!");
        }
    }

    @Override
    public String toString() {
        return "PlayGame{" +
                "playerList=" + playerList +
                '}';
    }
}
