package dicereview;

import java.util.ArrayList;
import java.util.List;

// 플레이어가 가지고 있는 것을 생각해보기
// 주사위 이름 성적 이정도를 여기에 만들어보자
// 성적은 좀 나중으로 미루기 지금은 이름과 주사위를 할당하는 것에 초점을 맞추자
public class DiceGame {
    private int DICE_NUM = 3;
    private String name;
    List<DiceRandom> diceRandomList = new ArrayList<>();
    int diceScore = 0;

    public DiceGame(String name) {
        this.name = name;

        for (int i = 0; i < DICE_NUM; i++) {
            diceRandomList.add(new DiceRandom(DICE_NUM));
            // 다이스의 합
            diceScore += diceRandomList.get(i).getDiceNumber();
        }
    }

    // 조건식 세우기

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", diceRandomList=" + diceRandomList +
                ", diceScore=" + diceScore +
                '}';
    }
}
