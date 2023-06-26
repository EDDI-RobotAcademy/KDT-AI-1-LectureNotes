package review1.dawun.controller;

import review1.dawun.ReviewGameManager6;

public class FirstDiceGameReview6 {
    public static void main(String[] args) {
        ReviewGameManager6 gamemanager = new ReviewGameManager6();
        System.out.println("판정 후");
        gamemanager.playGame2();
        gamemanager.printResult();
    }
}
