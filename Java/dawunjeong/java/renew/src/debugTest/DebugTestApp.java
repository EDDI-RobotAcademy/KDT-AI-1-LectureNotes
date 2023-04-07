package debugTest;

import diceGame.player.Player;
import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class DebugTestApp {

    private static List<Player> playerList = new ArrayList<>();

    public static int findTargetPlayerIndex (int currentPlayerIndex) {
        boolean forControlWord = true;
        int TargetPlayerIndex = 0;

        for (;forControlWord; ) {
            TargetPlayerIndex = CustomRandom.generateNumber(playerList.size());

            if (currentPlayerIndex == TargetPlayerIndex) {
                continue;
            }
            forControlWord = false;
        }
        return TargetPlayerIndex;
    }
    public static void main(String[] args) {
        playerList.add(new Player("안녕1"));
        playerList.add(new Player("안녕2"));
        playerList.add(new Player("안녕3"));

        int targetPlayerIndex = findTargetPlayerIndex(0);

        System.out.println("상대편 인덱스 = " + targetPlayerIndex);
    }
}