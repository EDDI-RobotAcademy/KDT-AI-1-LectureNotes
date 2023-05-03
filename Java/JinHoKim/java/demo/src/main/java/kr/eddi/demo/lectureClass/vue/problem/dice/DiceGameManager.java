package kr.eddi.demo.lectureClass.vue.problem.dice;


import kr.eddi.demo.lectureClass.vue.problem.player.Player;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class DiceGameManager {

    private List<Player> playerList;

    public DiceGameManager(int diceMaxNumber) {
        playerList = new ArrayList<>();

        playerList.add(new Player(diceMaxNumber));
    }

    public String checkWinIfSumEven(int playerDiceSumResult) {
        final int DECISION_WIN = 2;
        final int EVEN = 0;

        if (playerDiceSumResult % DECISION_WIN == EVEN) {
            return "Win!";
        }

        return "Lose!";
    }

    public int calculatePlayerDiceSum() {
        final List<Dice> currentPlayerDiceList = playerList.get(0).getDiceList();

        int tmpSum = 0;
        for (int i = 0; i < currentPlayerDiceList.size(); i++) {
            tmpSum += currentPlayerDiceList.get(i).getDiceNumber();
        }
        return tmpSum;
    }
}
