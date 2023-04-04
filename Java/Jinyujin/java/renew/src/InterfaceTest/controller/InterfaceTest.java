package InterfaceTest.controller;

import InterfaceTest.game.RpgGame;

public class InterfaceTest {

    public static void main(String[] args) throws InterruptedException {
        RpgGame rpgGame = new RpgGame();
        System.out.println(rpgGame);

        rpgGame.playGame();
        System.out.println(rpgGame); // 끝나고 몬스터 상태 보여주는 리스트
    }
}
