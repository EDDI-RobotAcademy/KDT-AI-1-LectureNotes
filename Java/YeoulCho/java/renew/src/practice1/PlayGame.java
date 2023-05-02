package practice1;

import diceGame.game.GameManager;

public class PlayGame {
    public static void main(String[] args) {
        DiceGame dicegame = new DiceGame();
        System.out.println("점수 판정 이후");
        Dicegame.playGame();
        Dicegame.printResult();
        Dicegame.checkWinner();
    }
}


