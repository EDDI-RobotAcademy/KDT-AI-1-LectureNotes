package dicegame.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameController {
    public static void main(String[] args) {

        System.out.print("player의 수를 입럭해주세요 > ");

        GameManager gameManager = new GameManager();
        System.out.println("점수 판정 이후");
        gameManager.playGame();
        gameManager.printResult();
        gameManager.checkWinner();

    }
}
