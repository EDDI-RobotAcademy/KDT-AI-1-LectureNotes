package homework.diceGame.controller;

import homework.diceGame.game.GameManager2;

public class DiceGameController {
    public static void main(String[] args) {
        GameManager2 gamemanager2 = new GameManager2();

        System.out.println("판정 후");
        gamemanager2.playGame2();
        gamemanager2.printResult();

        System.out.println("최종 순위");
        gamemanager2.checkWinner();
    }
}
