package com.example.demo.lectureClass.vue.homework.dicegame.player;

import com.example.demo.lectureClass.vue.homework.dicegame.game.Dice;
import com.example.demo.lectureClass.vue.homework.dicegame.game.GameScore;

import java.util.ArrayList;
import java.util.List;

public class Player implements Comparable<Player> {
    final private int MAX_DICE_NUM = 3;
    final private String name;
    final private List<Dice> diceList = new ArrayList<>();
    final private GameScore gameScore;

    public Player(String name) {
        this.name = name;

        int diceNumberSum = rollDice();
        gameScore = new GameScore(diceNumberSum);
    }

    private int rollDice() {
        final int FIRST_DICE_INFO = 0;
        final int DECISION_EVEN = 2;
        final int ODD = 1;

        int diceNumberSum = 0;

        for (int i = 0; i < MAX_DICE_NUM; i++) {
            diceList.add(new Dice());

            diceNumberSum += diceList.get(i).getDiceNumber();

            if (diceList.get(FIRST_DICE_INFO).getDiceNumber() %
                    DECISION_EVEN == ODD) {
                break;
            }
        }

        return diceNumberSum;
    }

    public Dice getSelectedGameDice(int index) {
        if (diceList.size() > index) {
            return diceList.get(index);
        }

        return null;
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
                ", diceList=" + diceList +
                ", gameScore=" + gameScore +
                '}';
    }

    public int compareTo(Player otherPlayer) {
        final int otherPlayerTotalScore = otherPlayer.getGameScore().getTotalScore();
        final int currentPlayerTotalScore = this.getGameScore().getTotalScore();

        if (otherPlayerTotalScore < currentPlayerTotalScore) {
            return 1;
        } else if (otherPlayerTotalScore > currentPlayerTotalScore) {
            return -1;
        }

        return 0;
    }
}
