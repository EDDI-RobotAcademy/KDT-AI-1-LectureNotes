package review1.sangwon;

import java.util.Scanner;

public class ReviewPlayer3 {
    String playerName1;
    String playerName2;
    Scanner sc1 = new Scanner(System.in);
    Scanner sc2 = new Scanner(System.in);

    public void addPlayer() {
        System.out.print("플레이어 1 이름을 입력해주세요 : ");
        playerName1 = sc1.nextLine();

        System.out.print("플레이어 2 이름을 입력해주세요 : ");
        playerName2 = sc2.nextLine();
    }
}
