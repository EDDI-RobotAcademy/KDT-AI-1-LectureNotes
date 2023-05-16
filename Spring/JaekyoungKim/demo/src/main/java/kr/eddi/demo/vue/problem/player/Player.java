package kr.eddi.demo.vue.problem.player;



import kr.eddi.demo.vue.problem.dice.Dice;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class Player {
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

        final int EVEN_DICISION = 2;
        final int ODD = 1;

        for (int i = 0; i < diceMaxNumber; i++) {
            //3번의 랜덤 주사위를 생성해서 리스트에 넣어줍니다.
            final Dice dice = new Dice();
            diceList.add(dice);
            //3개의 주사위를 더한 값이 diceSum 입니다.
            diceSum += dice.getDiceNumber();
            //첫 번째 주사위를 던질때 짝수 주사위라면 던지는 걸 멈춰버립니다.
            if (i == conditionDiceIdx) {
                //조건 주사위
                if (dice.getDiceNumber() % EVEN_DICISION == ODD) {
                    break;
                }
            }
        }
    }

    public Dice getDice (int idx) {
        if (diceList.size() - 1 < idx) {
            return null;
        }

        return diceList.get(idx);
    }

    public void setDiceSum (int score) {
        this.diceSum = score;
    }}