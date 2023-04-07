package finalDice;

import finalDice.manager.FinalDiceGameManager;

public class GameController {
    public static void main(String[] args) {
        FinalDiceGameManager finalDiceGameManager = new FinalDiceGameManager();
        System.out.println("점수 판정 이후");
        finalDiceGameManager.playGame();
        finalDiceGameManager.printResult();
        finalDiceGameManager.checkWinner();
    }
}
