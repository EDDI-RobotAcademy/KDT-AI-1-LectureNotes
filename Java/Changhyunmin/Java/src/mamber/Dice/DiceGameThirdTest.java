package mamber.Dice;

class ThirdDiceGame {
    final private int PLAYER_NUM = 2;
    final private Player[] playerArray = new Player[PLAYER_NUM];

    public ThirdDiceGame() {
        for (int i = 0; i < PLAYER_NUM; i++) {
            playerArray[i] = new Player("플레이어" + (i + 1));
            System.out.println(playerArray[i]);
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
                playerArray[playerIndex].getSelectedDice(SPECLA_DICE_INDEX);
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

            Score tarhetPlayerScore = playerArray[tagetPlayerIndex].getSc();
            Score currentPlayerScore = playerArray[i].getSc();

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
            System.out.println(playerArray[i]);
        }
    }
    public void checkWinner() {
        Score firstPlayerScore = playerArray[0].getSc();
        Score secondPlayerScore = playerArray[1].getSc();

        if (firstPlayerScore.getTotalScore() > secondPlayerScore.getTotalScore()) {
            System.out.println("승자: " + playerArray[0].getName());
        }else {
            System.out.println("승자: " + playerArray[1].getName());
        }
    }
}
public class DiceGameThirdTest {
    public static void main(String[] args) {
        ThirdDiceGame game = new ThirdDiceGame();
        System.out.println("점수 판정 이후");
        game.playGame();
        game.printResilt();
        game.checkWinner();
    }
}