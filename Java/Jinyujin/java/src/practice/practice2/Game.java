package practice.practice2;

import java.util.ArrayList;
import java.util.List;

public class Game {

    // 주사위 가져와서 4개 굴리기 - for 문 이용
    final int MAX_DICE = 4;
    List<Dice> diceList = new ArrayList<>();

    public Game() {

        for (int i = 0; i < MAX_DICE; i++) {
            diceList.add(new Dice());
            diceSum += diceList.get(i).diceNumber;
        }
    }

    final int WIN_DECISION_NUMBER1 = 3;
    final int WIN_DECISION_NUMBER2 = 4;
    int diceSum = 0;


    public void Score() {

        if (diceSum % WIN_DECISION_NUMBER1 == 0 ||
                diceSum % WIN_DECISION_NUMBER2 == 0) {
            System.out.println("승리");
        } else {
            System.out.println("패배");
        }
    }

    @Override
    public String toString() {
        return "Game{" +
                "diceList=" + diceList +
                ", diceSum=" + diceSum +
                '}';
    }
}
