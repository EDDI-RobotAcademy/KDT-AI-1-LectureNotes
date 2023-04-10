package dicereview;

import java.util.ArrayList;
import java.util.List;

// 시도할 것 리스트를 둘로 나눠서 그 안에 다이스 리스트를 집어넣기
// 승자판정은 나중으로 일단 어떻게 만들어야 효율적인지 저 부분을 정확하게 알고 넘어가기
// List로 for문을 돌릴땐 List내부의 이름을 사용하여 돌려야함
// List안에 다른 class를 가져와야하기때문에 DiceGame안에 DicePlayerList를 만든다
public class DicePlayer {
    private int PLAYER_NUM = 2;
    List<DiceGame> diceplayerList = new ArrayList<>();


    public DicePlayer() {

        for (int i = 0; i < PLAYER_NUM; i++) {
            diceplayerList.add(new DiceGame("플레이어" + (i + 1)));
            // diceplayerList안에 있는 i를 뽑아와야하기때문에 get(i)
            System.out.println(diceplayerList.get(i));
        }
    }
    // 상대편을 찾는 코드가 필요함

    public int getPLAYER_NUM() {
        return PLAYER_NUM;
    }

    public List<DiceGame> getDiceplayerList() {
        return diceplayerList;
    }

}

