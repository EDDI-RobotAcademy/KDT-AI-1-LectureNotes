package customLibrary;

import java.util.ArrayList;
import java.util.List;

public class RefactorPlayer {
    final private String name;
    RefactorDice dice = new RefactorDice();
    int diceNumber;
    final private RefactorDicegameScore gameScore;

    public RefactorPlayer(String name) {
        this.name = name;

        diceNumber = rollEveryDicesIfWeCan();
        gameScore = new RefactorDicegameScore(diceNumber);
    }

    private int rollEveryDicesIfWeCan() {
        int diceNumber = dice.getDiceNumber();
        return diceNumber;
    }

    public int getDiceNumber() {
        return diceNumber;
    }

    public RefactorDicegameScore getGameScore() {
        return gameScore;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "RefactorPlayer{" +
                "name='" + name + '\'' +
                ", diceNumber=" + diceNumber +
                ", gameScore=" + gameScore +
                '}';
    }

    public int compareTo(RefactorPlayer otherPlayer) {
        final int otherPlayerTotalScore = otherPlayer.getGameScore().getTotalScore();
        final int currentPlayerTotalScore = this.getGameScore().getTotalScore();

        if (otherPlayerTotalScore < currentPlayerTotalScore) {
            return 1;
        } else if (otherPlayerTotalScore > currentPlayerTotalScore) {
            return -1;
        }

        return 0;
    }
}
