package com.example.demo.lectureClass.vue.problem.player;

import com.example.demo.lectureClass.vue.problem.dice.Dice;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class Player {
    // 플레이어 클래스에서는 주사위에 대한 정보를 다룸
    final List<Dice> diceList;

    public Player(int diceMaxNumber) {
        diceList = new ArrayList<>();
        // 일단 여기서는 다이스리스트 추가해주지 않음

        for (int i = 0; i < diceMaxNumber; i++) {
            diceList.add(new Dice());
        }
    }
}
