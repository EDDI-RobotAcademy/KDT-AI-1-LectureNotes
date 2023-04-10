package problems.prob27;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    final private int PLAYER_NUM = 10;
    final private int EVEN_CHECK = 2;
    final private List<Player> playerList = new ArrayList<>();

    public GameManager() {
        for (int i = 0; i < PLAYER_NUM; i++) {
            playerList.add(new Player("플레이어" + (i + 1)));
            System.out.println(playerList.get(i));
        }
    }

    public void checkDiceNumber(int diceNumber){

        if(diceNumber % EVEN_CHECK == 0){

        }
    }

    @Override
    public String toString() {
        return "GamaManager{" +
                "playerList=" + playerList +
                '}';
    }
}
