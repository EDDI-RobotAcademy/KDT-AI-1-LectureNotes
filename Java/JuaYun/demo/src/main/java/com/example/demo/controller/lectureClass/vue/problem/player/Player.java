package com.example.demo.controller.lectureClass.vue.problem.player;

import com.example.demo.controller.lectureClass.vue.problem.dice.Dice;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@ToString
@Getter
public class Player {
    // static 추가해줌
    // 안받아줘서 지웠음
    // private final int diceMaxNumber;
    // this.diceMaxNumber = diceMaxNumber; 이 부분들도 삭제 깔끔함을 위해
    private List<Dice> diceList;
    private int diceSum;
    private String name;

    public Player(int diceMaxNumber) {
        diceList = new ArrayList<>();

        for (int i = 0; i < diceMaxNumber; i++) {
            diceList.add(new Dice());
        }
    }
    public Player(int diceMaxNumber, int conditionDiceIdx, int nameIdx) {
        diceList = new ArrayList<>();
        diceSum = 0;

        name = "player" + nameIdx;

        final int EVEN_DECISION = 2;
        final int ODD = 1;

        for (int i = 0; i < diceMaxNumber; i++) {
            final Dice dice = new Dice();
            diceList.add(dice);

            diceSum += dice.getDiceNumber();

            if (i == conditionDiceIdx) {
                if (dice.getDiceNumber() % EVEN_DECISION == ODD) {
                    break;
                }
            }
        }
    }
    public Dice getDice (int idx)  { // 매니저쪽에 인덱스를 리턴
        if (diceList.size() - 1 < idx) {
            return null;
        }
        return diceList.get(idx);
    }

    public void setDiceSum (int score) {
        this.diceSum = score;
    }
}
