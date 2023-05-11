package practice.dice3.diceGame3BackLogPractice;

import java.util.ArrayList;
import java.util.List;

// 플레이어가 주사위 굴려야 함
public class Player {
    final int DICE_COUNT = 3;
    final private String name;
    final private Score score;
    final List<Dice> diceList = new ArrayList<>();


    public Player(String name) {
        this.name = name;

        int diceSum = diceRoll();
        score = new Score(diceSum);
        // 이걸 해줘야 플레이어의 합산 값이 score가 됨!!
    }

    public int diceRoll() {

        final int FIRST_DICE_NUMBER = 0;
        final int EVEN_DICE_DECISION = 2;
        final int ODD = 1;

        int diceSum = 0;

        for (int i = 0; i < DICE_COUNT; i++) {

            diceList.add(new Dice());
            diceSum += diceList.get(i).getDiceNumber();

            // 첫 번째 주사위 조건 적용하기
            if (diceList.get(FIRST_DICE_NUMBER).getDiceNumber() % EVEN_DICE_DECISION == ODD) {
                break;
            }
        }
        return diceSum;
    }

    // 몇 번째 주사위인지 return해주는 메서드
    // 존나 어렵다 - 이 부분 이해 못함
    // Dice 클래스로 생성자 만들어줌
//    public Dice needToSelectDice(int Idx) {
//        return diceList.get(Idx);
//    }
    // 이 부분에서도 두 번째 인덱스를 무조건 획득하려함
    // 2번 인덱스가 없는 상황에서도 획득하려고 하기 때문에 IndexOutOfBoundsException 오류가 발생

    public Dice needToSelectDice(int idx) {
        int diceListSize = diceList.size();

        if (diceListSize < idx + 1) {
            return null;
        }
        return diceList.get(idx);
    }

    public Score getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", diceList=" + diceList +
                ", score=" + score +
                '}';
    }
}
