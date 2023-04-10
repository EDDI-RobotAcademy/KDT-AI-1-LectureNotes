package finalDice;

import finalDice.manager.FinalDiceGameManager;

public class GameController {
    public static void main(String[] args) {
        FinalDiceGameManager gameManager = new FinalDiceGameManager();
        System.out.println("점수 판정 이후");

        gameManager.playGame();
        gameManager.printResult();
        gameManager.checkWinner();
    }
}