package com.example.demo.lectureClass.homework.basic1.answer.problem2.player;

import com.example.demo.lectureClass.homework.basic1.answer.problem2.dice.Dice;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@ToString
@Getter
public class Player {
    List<Dice> diceList;

    public Player (int diceMaxNumber) {

        diceList = new ArrayList<>();
        for (int i = 0; i < diceMaxNumber; i++) {
            diceList.add(new Dice());
        }
    }
}
