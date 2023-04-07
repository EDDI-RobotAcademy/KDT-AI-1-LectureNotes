package zhomework6.game.controller;

import zhomework6.game.GameManager;


public class GameController {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        System.out.println("점수 판정 이후");
        gameManager.playGame();
        gameManager.printResult(); // 플레이어 1 2 출력 함수
        gameManager.checkWinner();
    }
}
