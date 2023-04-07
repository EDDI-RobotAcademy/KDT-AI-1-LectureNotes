package question.homework.dice;

import java.util.ArrayList;
import java.util.List;

public class DiceGame {
    final private int PLAYER_NUM = 2;
    List<Player>playerArray =new ArrayList<>();
    //final private Player[] playerArray = new Player[PLAYER_NUM];
    // 배열을 List로 변환
    public DiceGame() {
        for (int i = 0; i < PLAYER_NUM; i++) {
            playerArray.add(new Player(("플레이어" + (i + 1))));
            //playerArray[i] = new GamePlayer("플레이어" + (i + 1));
            //playerArray[i]에 new GamePlayer("플레이어" + (i + 1))이 들어가기 때문에 .add()
            System.out.println(playerArray);
        }
    }
    private int findTargerPlayerIndex (int currentPlayerIndex) {
        int targetPlayerIndex = 0;
        if (currentPlayerIndex == 0) {
            targetPlayerIndex = 1;
        }
        return targetPlayerIndex;
    }
    private int findSpecialDiceNumber (int playerIndex) {
        final int ARRAY_BIAS = 1;
        final int SPECLA_DICE_INDEX = 3 - ARRAY_BIAS;

        Dice currentPlayerSpecialDice =
                playerArray.get(playerIndex).getSelectedDice(SPECLA_DICE_INDEX);
        if (currentPlayerSpecialDice == null) {return 0;}

        int currentPlayerSpecialDiceNumber = currentPlayerSpecialDice.getDiceNumber();

        return currentPlayerSpecialDiceNumber;

    }

    public void playGame() {
        final int STEAL = 1;
        final int BUFF = 3;
        final int DEATH = 4;

        final int STEAL_SCORE = 3;
        final int BUFF_SCORE = 2;
        final int DEATH_SCORE = -1;

        for(int i = 0; i < PLAYER_NUM; i++) {
            int currentPlayerSpecialDiceNumber = findSpecialDiceNumber(i);
            if(currentPlayerSpecialDiceNumber == 0) {continue;}

            int tagetPlayerIndex = findTargerPlayerIndex(i);

            Score tarhetPlayerScore = playerArray.get(tagetPlayerIndex).getSc();
            // = playerArray[tagetPlayerIndex].get Sc();
            // playerArray에 []이 들어가있으면 .get()으로 변경
            Score currentPlayerScore = playerArray.get(i).getSc();

            switch (currentPlayerSpecialDiceNumber) {
                case STEAL:
                    tarhetPlayerScore.takeScore(currentPlayerScore,STEAL_SCORE);
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
    public void printResilt() {
        for (int i = 0; i < PLAYER_NUM; i++) {
            System.out.println(playerArray);
        }
    }
    public void checkWinner() {
        Score firstPlayerScore = playerArray.get(0).getSc();
        Score secondPlayerScore = playerArray.get(1).getSc();

        if (firstPlayerScore.getTotalScore() > secondPlayerScore.getTotalScore()) {
            System.out.println("승자: " + playerArray.get(0).getName());
        }else {
            System.out.println("승자: " + playerArray.get(1).getName());
        }
    }
}
