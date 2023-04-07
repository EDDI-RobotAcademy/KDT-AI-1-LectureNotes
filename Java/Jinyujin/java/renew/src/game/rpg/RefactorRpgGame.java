package game.rpg;

// 어제 하던 rpg게임 - 게임캐릭터와 몬스터 코드 동일한 작업을 한 군데에서 반복해서 지저분해 보였음
// 또한 게임캐릭터와 몬스터에서 공통적인 요소들 반복해서 선언
// → refactor

import game.rpg.controller.RefactorGameManager;

public class RefactorRpgGame {

    public static void main(String[] args) throws InterruptedException {
        RefactorGameManager refactorGameManager = new RefactorGameManager();
        System.out.println(refactorGameManager);

        refactorGameManager.playGame();
    }
}
