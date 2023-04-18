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
    List<Dice> diceList;

    public Player(int diceMaxNumber) {

        diceList = new ArrayList<>();
        for (int i = 0; i < diceMaxNumber; i++) {
            diceList.add(new Dice());
        }
    }
}
