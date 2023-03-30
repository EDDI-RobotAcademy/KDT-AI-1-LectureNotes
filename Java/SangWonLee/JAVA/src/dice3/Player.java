package dice3;

import java.util.Scanner;

public class Player {
    String playerName1;
    String playerName2;

    Scanner sc1 = new Scanner(System.in);
    Scanner sc2 = new Scanner(System.in);

    public void addPlayer() {
        System.out.print("플레이어 1 이름을 입력해주세요 : ");
        playerName1 = sc1.nextLine();
        System.out.print("플레이어 2 이름을 입력해주세요 : ");
        playerName2 = sc2.nextLine();

        setPlayerName1(playerName1);
        setPlayerName2(playerName2);

    }

    public String getPlayerName1() {
        return playerName1;
    }

    public void setPlayerName1(String playerName1) {
        this.playerName1 = playerName1;
    }

    public String getPlayerName2() {
        return playerName2;
    }

    public void setPlayerName2(String playerName2) {
        this.playerName2 = playerName2;
    }
}
