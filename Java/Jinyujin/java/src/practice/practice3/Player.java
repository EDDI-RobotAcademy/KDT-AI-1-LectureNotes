package practice.practice3;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Dice> diceList = new ArrayList<>();
    final int MAX_DICE_COUNT = 3;

    public int getDiceSum() {
        return diceSum;
    }

    public int setDiceSum(int diceSum) {
        this.diceSum = diceSum;
        return diceSum;
    }

    private int diceSum = 0;
    final private int FIRST_DICE_INFO = 0;
    final private int ODD = 1;
    private Score score;

    public List<Dice> getDiceList() {
        return diceList;
    }

    public String getName() {
        return name;
    }

    public Player(String name) {// 처음 생성할 때 정해지는 것들은 보통 안바뀌기에 생성자에서 선언 (이름 같은)
         this.name = name;

        // 플레이어가 주사위를 굴려야해
        for (int i = 0; i < MAX_DICE_COUNT; i++) {
            diceList.add(new Dice());
            diceSum += diceList.get(i).diceNumber2;

            if (diceList.get(FIRST_DICE_INFO).diceNumber2 % 2 == ODD) {
                break;
            }
        }
        this.score = new Score(diceSum);
    }

    public Score getScore() {
        return score;
    }

    @Override
    public String toString() {
        return '\n' + "Player{" +
                "name='" + name + '\'' +
                ", diceList=" + diceList +
                '\n' + "diceSum=" + diceSum +
                ", score=" + score +
                '}';
    }


}
