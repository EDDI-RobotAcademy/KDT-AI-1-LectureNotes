package homework.homework6.diceGame5.diceGame.player;


import diceGame.game.Dice;
import diceGame.game.GameScore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Player(플레이어)에게 필요한게 뭐지 ?
public class Player {
    final private int MAX_DICE_NUM = 3;
    final private String name;
    final private List<Dice> gameDiceList = new ArrayList<>();
    final private GameScore gameScore;
    public static int startPlayerNum = 0;
    public static Map<Integer, Player> allPlayers = new HashMap<>(); //넘버와 Player의 맵


    public Player(String name) {
        this.name = name;

        int diceNumberSum = rollDice();
        gameScore = new GameScore(diceNumberSum);
    }


//    public void playerInfoToMap(Player player) { //추가하는 플레이어정보 {0, player} {1, player}..
//        allPlayers.put(startPlayerNum, player);
//        startPlayerNum++;
//    }


    private int rollDice() {
        final int FIRST_DICE_INFO = 0;
        final int DECISION_EVEN = 2;
        final int ODD = 1;

        int diceNumberSum = 0;

        for (int i = 0; i < MAX_DICE_NUM; i++) {
            gameDiceList.add(new Dice());

            diceNumberSum += gameDiceList.get(i).getDiceNumber();

            if (gameDiceList.get(FIRST_DICE_INFO).getDiceNumber() %
                    DECISION_EVEN == ODD) {
                break;
            }
        }

        return diceNumberSum;
    }

    public Dice getSelectedGameDice(int index) {

        return gameDiceList.get(index);
    }

    public GameScore getGameScore() {
        return gameScore;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", gameDiceList=" + gameDiceList +
                ", gameScore=" + gameScore +
                '}';
    }
}
