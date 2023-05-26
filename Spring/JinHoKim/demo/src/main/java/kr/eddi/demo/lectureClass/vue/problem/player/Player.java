package kr.eddi.demo.lectureClass.vue.problem.player;

import kr.eddi.demo.lectureClass.vue.problem.dice.Dice;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class Player {
    List<Dice> diceList;

    public Player(int diceMaxNumber) {
        diceList = new ArrayList<>();
        for (int i = 0; i < diceMaxNumber; i++) {
            diceList.add(new Dice());
        }
    }

}
