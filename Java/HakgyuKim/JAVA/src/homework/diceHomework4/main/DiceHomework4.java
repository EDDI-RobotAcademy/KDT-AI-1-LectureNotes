package homework.diceHomework4.main;

import homework.diceHomework4.component.Player;

import java.util.ArrayList;
import java.util.List;

class DiceGame4 {
    final private int PLAYER_NUM = 2;
    List<String> playerList = new ArrayList<String>();
    public DiceGame4() {
        for (int i = 0; i < PLAYER_NUM; i++) {
            playerList.add("플레이어" + (i+1));
        }
    }

    public List<String> getPlayerList() {
        return playerList;
    }
}
public class DiceHomework4 {
    public static void main(String[] args) {
        DiceGame4 game = new DiceGame4();
        Player player = new Player("플레이어3");
        System.out.println(game.getPlayerList());
        System.out.println(player.getScore());
    }
}
