package practice.practice1;

import practice.practice1.Dice;
import practice.practice1.Game;
import practice.practice1.Player;

public class ThirdDiceGame {

    public static void main(String[] args) {
        // 게임객체() 생성
        Game game = new Game();
        // 게임객체.게임플레이()
//        game.gameplay();

        Dice dice = new Dice();
        System.out.println(dice);

        Player player = new Player("김이름");
        System.out.println(player);

    }
}
