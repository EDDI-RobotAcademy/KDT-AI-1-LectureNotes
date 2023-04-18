package com.example.demo.lectureClass.homework.problem.problem2.dice;

import com.example.demo.lectureClass.homework.problem.problem2.player.Player;

import java.util.ArrayList;
import java.util.List;

public class DiceGameManager {
    private List<Player> playerList;

    public DiceGameManager(int diceMaxNumber) {
        playerList = new ArrayList<>();
        playerList.add(new Player(diceMaxNumber));
    }

    public int calculatePlayerDiceSum(){
        final List<Dice> currentPlayerDiceList = playerList.get(0).getDiceList();
        int tmpSum=0;
        for( int i=0; i< currentPlayerDiceList.size(); i++){
            tmpSum += currentPlayerDiceList.get(i).getDiceNumber();
        }
        return tmpSum;
    }
    public String checkWinIfSumEven(int playerDiceSumResult){
        final int DECISION_WIN =2;
        final int EVEN =0;

        if(playerDiceSumResult % DECISION_WIN==EVEN){
        return "Win!";}
        return "Lose!";
    }
}
