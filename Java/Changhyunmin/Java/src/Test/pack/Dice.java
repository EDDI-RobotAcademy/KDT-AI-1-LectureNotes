package Test.pack;

import utility.random.CustomRandom;

import java.util.Arrays;

class GameDice{
    final int MIN = 1;
    final int MAX = 6;
    final private int diceNumber;

    public GameDice(){
        this.diceNumber = CustomRandom.generateNumber(MIN, MAX);
    }
    public int getDiceNumber() {
        return diceNumber;
    }

    @Override
    public String toString() {
        return "주사위 값: '" + diceNumber + "'";
    }
}


class GamePlayer{
    final private int MAX_DICE_NUM = 3;
    final private String name;
    final private GameDice[] gameDices = new GameDice[MAX_DICE_NUM];
    final private GameScore gameScore;
    public GamePlayer(String name) {
        this.name = name;

        int diceNumberSum = rollDice();
        gameScore = new GameScore(diceNumberSum);
    }
    private int rollDice() {
        final int FIRST_DICE_INFO = 0;
        final int DECISION_EVEN = 2;
        final int ODD = 1;

        int diceNumberSum = 0;

        for(int i = 0; i < MAX_DICE_NUM; i++) {
            gameDices[i] = new GameDice();

            diceNumberSum += gameDices[1].getDiceNumber();

            if (gameDices[FIRST_DICE_INFO].getDiceNumber() %DECISION_EVEN == ODD) {
                break;
            }
        }
        return diceNumberSum;
    }

    public String getName() {
        return name;
    }

    public GameDice getGameDice(int index) {
        return gameDices[index];
    }


    @Override
    public String toString() {
        return name + '\'' + ", 주사위 숫자: " + Arrays.toString(gameDices) +'\n' +
                ", 주사위 총합: " + gameScore;
    }
    public GameScore getGameScore() {
        return gameScore;
    }
}


class GameScore{
    private int totalScore;

    public GameScore(int totalScore) {
        this.totalScore = totalScore;
    }
    public void takeScore(GameScore otherScore, int stealScore) {
        this.totalScore -= stealScore;
        otherScore.totalScore += stealScore;
    }
    public void addScore(int buffScore) {
        this.totalScore = buffScore;
    }
    public void loseAll(int deathScore) {
        this.totalScore = deathScore;
    }
    public int getTotalScore(){
        return totalScore;
    }

    @Override
    public String toString() {
        return "GameScore{" +
                "totalScore=" + totalScore +
                '}';
    }

}
class ThirdDiceGame {

    final private int PLAYER_NUM = 2;
    final private GamePlayer[] playerArray = new GamePlayer[PLAYER_NUM];

    public ThirdDiceGame() {
        for (int i = 0; i < PLAYER_NUM; i++) {
            playerArray[i] = new GamePlayer("플레이어" + (i + 1));
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

        GameDice currentPlayerSpecialDice =
                playerArray[playerIndex].getGameDice(SPECIAL_DICE_INDEX);

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
            int currentPlayerSpecialDiceNumber = findSpecialDiceNumber(i);
            if (currentPlayerSpecialDiceNumber == 0) {
                continue;
            }

            int targetPlayerIndex = findTargetPlayerIndex(i);
            GameScore targetPlayerScore = playerArray[targetPlayerIndex].getGameScore();

            GameScore currentPlayerScore = playerArray[i].getGameScore();

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
            }
        }
    }

    public void printResult() {
        for (int i = 0; i < PLAYER_NUM; i++) {
            System.out.println(playerArray[i]);
        }
    }

    public void checkWinner() {
        GameScore firstPlayerScore = playerArray[0].getGameScore();
        GameScore secondPlayerScore = playerArray[1].getGameScore();

        if (firstPlayerScore.getTotalScore() > secondPlayerScore.getTotalScore()) {
            System.out.println("승자: " + playerArray[0].getName());
        } else {
            System.out.println("승자: " + playerArray[1].getName());
        }
    }
}
public class Dice {
    public static void main(String[] args) {

        ThirdDiceGame game = new ThirdDiceGame();
        System.out.println("점수 판정 이후");
        game.playGame();
        game.printResult();
        game.checkWinner();

    }


}