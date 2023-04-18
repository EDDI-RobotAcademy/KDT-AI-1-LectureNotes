package com.example.demo.lectureClass.vue.problem.dice;

import com.example.demo.lectureClass.vue.problem.player.Player;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class DiceGameManager {
    // 일단 게임매니저에서 플레이어 리스트를 관리
    private List<Player> playerList; //Player 리스트를 추가해줘야함

    public DiceGameManager(int diceMaxNumber) {
        playerList = new ArrayList<>();

        playerList.add(new Player(diceMaxNumber));
        // Player 클래스에 있는 플레이어 정보를 가져와서
        // 플레이어리스트에 추가해라
    }

    public String checkWinIfSumEven(int diceSum) {
        final int DICE_WIN = 2;
        final int EVEN = 0;

        if (diceSum % DICE_WIN == EVEN) {
            return "승리!";
        } else {
            return "패배!";
        }
    }

    public int calculatePlayerDiceSum() {
        // 플레이어의 주사위 합을 구하자
        // 먼저 플레이어의 주사위 리스트 가져오기
        int tmpSum = 0;
        List<Dice> PlayerDiceList = playerList.get(0).getDiceList();

        for (int i = 0; i < PlayerDiceList.size(); i++) {
            tmpSum += PlayerDiceList.get(i).getDiceNumber();
        }
        return tmpSum;
    }
}
