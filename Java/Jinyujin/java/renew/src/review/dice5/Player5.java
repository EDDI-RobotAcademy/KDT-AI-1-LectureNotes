package review.dice5;

import java.util.ArrayList;
import java.util.List;

// 플레이어에게 필요한건?
// 어떤 플레이어가 플레이하는지 필요 -> 이름 선언
// 각 플레이어가 주사위 3개 굴림 - for 문 이용
// 각 플레이어.. -> 플레이어 리스트 만들어야 하나? 아니야
// 플레이어 수만큼 주사위 굴리는건 게임클래스에서 실행
// 여기선 플레이어가 주사위를 굴릴꺼라는 생각 가져보자
// 주사위 합계까지 구해보자
public class Player5 {
    final private String name;
    final private List<Dice5> diceList = new ArrayList<>();
    final private int DICE_COUNT = 3;

    int diceSum = 0;

    public Player5(String name) { // 매개변수 있으니 이걸 활용해야 함..
        this.name = name;
    }

    // 여기서 주사위 리스트 만들어보자
    // 단순히 플레이어가 주사위를 굴릴꺼라는 생각으로
    // 주사위 합계까지
    public void rollDice() {
        for (int i = 0; i < DICE_COUNT; i++) {
            diceList.add(new Dice5());
            diceSum += diceList.get(i).getDiceNumber();
        }
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", diceList=" + diceList +
                ", diceSum=" + diceSum +
                '}';
    }
}
