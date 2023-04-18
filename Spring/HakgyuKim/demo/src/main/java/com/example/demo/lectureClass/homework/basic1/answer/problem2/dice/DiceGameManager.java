package com.example.demo.lectureClass.homework.basic1.answer.problem2.dice;

import com.example.demo.lectureClass.homework.basic1.answer.problem2.player.Player;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class DiceGameManager {

    final private int diceMaxNumber;
    private List<Player> playerList;

    public DiceGameManager(int diceMaxNumber) {
        this.diceMaxNumber = diceMaxNumber;
        playerList = new ArrayList<>();

        playerList.add(new Player(diceMaxNumber));
    }

    public String checkWinIfSumEven (int currentPlayerDiceSum) {
        final int DECISION_WIN = 2;
        final int EVEN = 0;

        if (currentPlayerDiceSum % DECISION_WIN == EVEN) {
            return "승리!";
        }
        return "패배!";
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
