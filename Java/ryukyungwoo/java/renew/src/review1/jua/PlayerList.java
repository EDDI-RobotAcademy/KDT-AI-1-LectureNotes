package review1.jua;

import java.util.ArrayList;
import java.util.List;

public class PlayerList {
    // 위에서 주사위 리스트를 만들었습니다.
    // 그리고 리스트를 만들었으니까 여기서는 주사위와 관련된 정보가 필요 없습니다.
    // 고로 아래의 DICE_NUM은 PLAYER_NUM으로 바꿔주는 것이 더 좋을 것입니다.
    // 1:1을 상정 했으니 2로 설정하겠습니다.
    private int PLAYER_NUM = 2;
    // private int PLAYER_NUM = 3;
    List<Integer> playerList = new ArrayList<Integer>();

    // 아래 생성자를 살펴보니 playerList.add로 i 값을 저장하고 있습니다.
    // 이렇게 되면 playerList는 아래와 같은 형태가 됩니다.
    // [index 0, 0] -> [index 1, 1]
    // 근데 실제로 여기에는 플레이어의 정보가 담겨야하고
    // 플레이어의 정보는 현재로서는 주사위 리스트를 가지고 있으면 됩니다.
    // 고로 List 내부에 List를 넣는 상황이 필요해집니다.
    // 설계 구조가 예쁘진 않지만 만들어보겠습니다.
    List<List<Integer>> playerDiceList = new ArrayList<>();

    public PlayerList(List<Integer> diceList) {
        for (int i = 0; i < PLAYER_NUM; i++) {
            // 현재 설계 구조에서는 이런식으로 외부에서 주입 받아야 합니다.
            playerDiceList.add(diceList);
        }
    }

    public PlayerList() {
        final int DICE_NUMBER = 3;

        for (int i = 0; i < PLAYER_NUM; i++) {
            // 이 구성이라면 루프 내에서 리스트를 만들고
            // 사용자 리스트에 리스트를 추가하게 됩니다.
            // 매 루프마다요.
            // 고로 목적한 바를 이룰 수 있습니다.
            RandomDiceList randomDiceList = new RandomDiceList(DICE_NUMBER);
            playerDiceList.add(randomDiceList.getDiceList());
        }
    }

    @Override
    public String toString() {
        return "PlayerList{" +
                ", playerDiceList=" + playerDiceList +
                '}';
    }
}
