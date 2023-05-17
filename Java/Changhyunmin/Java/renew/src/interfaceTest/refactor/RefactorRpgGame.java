package interfaceTest.refactor;

import repector.RefactorManager;

public class RefactorRpgGame {
    public static void main(String[] args) throws InterruptedException{
        RefactorManager refactorManager = new RefactorManager();
        System.out.println(refactorManager);
        refactorManager.playGame();
    }
}
