package homework6.game;

import java.util.Scanner;

public class Player {
    final private String name;

    public Player(int playerIndex) {
        Scanner sc = new Scanner(System.in);
        System.out.println("플레이어" + (playerIndex + 1) + " 이름을 입력하세요: ");
        this.name = sc.nextLine();
    }

    public void roll(Dice dice) {
        dice.roll();
    }
    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }
}
