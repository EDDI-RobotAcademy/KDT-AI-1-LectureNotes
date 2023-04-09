package interfaceTest.controller;

import interfaceTest.game.RpgGame;

public class InterfaceTest {
    public static void main(String[] args) throws InterruptedException {
        RpgGame rpgGame = new RpgGame();
        System.out.println(rpgGame); // 게임 시작하기전 상황 프린트

        rpgGame.playGame(); // 게임 시작

        System.out.println(rpgGame); // 게임이 끝난 후 상황 프린트
    }

}