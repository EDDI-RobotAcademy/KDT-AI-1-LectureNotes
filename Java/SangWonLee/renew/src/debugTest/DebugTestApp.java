package debugTest;

import diceGame.player.RefactorPlayer;
import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class DebugTestApp {

    private static List<RefactorPlayer> refactorPlayerList = new ArrayList<>();

    public static int findTargetPlayerIndex (int currentPlayerIndex) {
        boolean forControlWord = true;
        int TargetPlayerIndex = 0;

        for (;forControlWord; ) {
            TargetPlayerIndex = CustomRandom.generateNumber(refactorPlayerList.size());

            if (currentPlayerIndex == TargetPlayerIndex) {
                continue;
            }
            forControlWord = false;
        }
        return TargetPlayerIndex;
    }
    public static void main(String[] args) {
        refactorPlayerList.add(new RefactorPlayer("안녕1"));
        refactorPlayerList.add(new RefactorPlayer("안녕2"));
        refactorPlayerList.add(new RefactorPlayer("안녕3"));

        int targetPlayerIndex = findTargetPlayerIndex(0);

        System.out.println("상대편 인덱스 = " + targetPlayerIndex);
    }
}