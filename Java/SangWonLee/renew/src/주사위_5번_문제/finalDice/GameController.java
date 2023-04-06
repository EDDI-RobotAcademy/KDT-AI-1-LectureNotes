package 주사위_5번_문제.finalDice;

import 주사위_5번_문제.finalDice.manager.FinalDiceGameManager;

public class GameController {
    public static void main(String[] args) {
        FinalDiceGameManager gameManager = new FinalDiceGameManager();
        System.out.println("점수 판정 이후");

        gameManager.playGame();
        gameManager.printResult();
        gameManager.checkWinner();
    }
}