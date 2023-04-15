package gameRpg;

import gameRpg.controller.RefactorGameManager;

public class RefactorRpgGame {
    public static void main(String[] args) throws InterruptedException {
        RefactorGameManager refactorGameManager = new RefactorGameManager();
        System.out.println(refactorGameManager);

        refactorGameManager.playGame();
    }
}