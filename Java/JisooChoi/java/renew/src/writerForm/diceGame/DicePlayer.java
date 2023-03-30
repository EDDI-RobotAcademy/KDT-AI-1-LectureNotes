package writerForm.diceGame;

public class DicePlayer {
    String name;
    int playerTotalScore;

    public DicePlayer(String name){
        this.name = name;
    }

    public int setPlayerTotalScore(int playerTotalScore) {
        return this.playerTotalScore = playerTotalScore;
    }

    public int getPlayerTotalScore() {
        return playerTotalScore;
    }
}
