package diceProblem;

import diceProblem.manager.FinalDiceGameManager;

public class GameController {
    public static void main(String[] args) {
        FinalDiceGameManager finalDiceGameManager = new FinalDiceGameManager();
        System.out.println("특수 주사위 판정 이후");
        finalDiceGameManager.playGame();
        finalDiceGameManager.printResult();
        finalDiceGameManager.checkWinner();
    }
}
