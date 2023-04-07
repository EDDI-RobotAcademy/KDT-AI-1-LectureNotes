package finalDice;

import finalDice.manager.FinalDiceGameManager;
import finalDice.review.manager.DiceGameManager;

public class GameController {
    public static void main(String[] args) {
        DiceGameManager gameManager = new DiceGameManager();
        System.out.println("점수 판정 이후");

//        gameManager.playGame();      // finalDiceGameManager
//        gameManager.printResult();   // finalDiceGameManager
//        gameManager.checkWinner();   // finalDiceGameManager
    }
}