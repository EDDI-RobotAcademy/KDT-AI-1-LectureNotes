package practice.dice3;

import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;
class GameManager {
    List<Player> playerList = new ArrayList<>();
    final private int THIRD_DICE_NUMBER = 3;
    final private int STEAL_CHECK_NUMBER = 3;
    final private int DEATH_CHECK_NUMBER = 4;
    public GameManager () {

    }
    public void checkEachNumber () {
        if (findSpecialDiceNumber(currentPlayerNumber,THIRD_DICE_NUMBER-1) == STEAL_CHECK_NUMBER) {
            targetPlayerNumber();
        }
    }
    public int findCurrentPlayerNumber () {
        int currentPlayerNumber;
    }


    public int targetPlayerNumber (List<Player> playerList, int currentPlayerNumber) {

    }
//    public int currentDiceNumber () {
//    }
    public int findSpecialDiceNumber (int playerNumber,int selectedDiceNumber) {
        return playerList.get(playerNumber).getDiceList().get(selectedDiceNumber).getDiceNumber();
    }
    public int findPlayerNumber () {
         }
//    public int searchPlayer (int searchPlayerNumber) {
//        PlayerList playerList = new PlayerList();
//        searchPlayerNumber = CustomRandom.generateNumber(playerList.getHOW_MANY_PLAYERS()-1);
//    return ;}
}
public class Game {
}