package practice.dice3;

import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;
class GameManager {
    PlayerList playerList;
    final private int FIRST_DECISION_DICE_NUM = 0;
    final private int ODD= 2;
    public GameManager () {
        if (findSpecialDiceNumber(FIRST_DECISION_DICE_NUM) % ODD == 0) {
            Player player = new Player();
            // Player에 for문을  if문으로 감싸기
            // 홀수 일때 break; 걸기
        }
    }
    public int findSpecialDiceNumber (int selectedDiceNumber) {
        Player player = new Player();
        return player.getDiceList(selectedDiceNumber).getDiceNumber();
    }
    public int findPlayerNumber (int selectedPlayerNumber) {
        PlayerList playerList = new PlayerList();
        return playerList.getPlayerNumber(selectedPlayerNumber);
    }
//    public int searchPlayer (int searchPlayerNumber) {
//        PlayerList playerList = new PlayerList();
//        searchPlayerNumber = CustomRandom.generateNumber(playerList.getHOW_MANY_PLAYERS()-1);
//    return ;}
}
public class Game {
}