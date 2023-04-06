package test.refecterDice;

import test.refecterDice.manager.FinalDiceGameManager;

public class RefactorController {
    public static void main(String[] args) {
        FinalDiceGameManager manager = new FinalDiceGameManager();
        System.out.println("점수 판정 이후");
        manager.playGame();
        manager.printResult();
        manager.checkWinner();
    }

}
