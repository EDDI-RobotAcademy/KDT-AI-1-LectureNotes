package practice.dice3.diceGame3BackLogPractice3.controller;

import practice.dice3.diceGame3BackLogPractice3.manager.GameManager;

public class GameController {
    public static void main(String[] args) {
//        Player player = new Player("플레이어");
//        player.rollDice();
//        System.out.println(player);

        GameManager game = new GameManager();
        game.playGame();
        System.out.println("승자 판정 이후");
        game.nextToThirdCondition();
        game.checkWin();
    }
}
