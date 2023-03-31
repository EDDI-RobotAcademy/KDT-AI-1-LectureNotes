package practice.dice3;

import java.util.ArrayList;
import java.util.List;

public class Player {
// 1. 플레이어가 다이스를 가져야 함
// 2. 그럼 일단 다이스 만들기
// 8. 일단 만들었고
// 9. 그럼 플레이어가 다이스를 3개 가져야 되니까
//      다이스로 리스트를 만들기
    List<Dice> diceList = new ArrayList<>();
    // 10. List<> 안의 데이터타입에 유의할 것
    //      다이스 리스트를 만들기 위해 Dice()를 가져왔는데
    //      Player로 지정해놔서 안됐던것
    final private Player player;
    final private int MAX_DICE_NUM = 3;
    public Player () {
        for (int i = 0; i < MAX_DICE_NUM; i++) {
            diceList.add(new Dice());
        }
    }
    @Override
    public String toString() {
        return "Player{" +
                "diceList=" + diceList +
                '}' + '\n';
    }
}
