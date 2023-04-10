package review.dice5;

import java.util.ArrayList;
import java.util.List;

// 각 플레이어가 주사위 3개 굴리도록
// 플레이어 리스트와 주사위를 가지고 오자
// 플레이어 리스트에 있는 플레이어들이 주사위 굴려서 주사위 수 하나씩 가질 수 있도록
public class Game5 {
    final private List<Player5> playerList = new ArrayList<>();
    final private int PLAYER_COUNT = 2;

    public Game5() {
        for (int i = 0; i < PLAYER_COUNT; i++) {
            playerList.add(new Player5("플레이어" + (i+1))); // 플레이어 수만큼 리스트 생성
        }
    }

    public void gamePlay() {

    }

    public void checkWin() {
    }

    @Override
    public String toString() {
        return "Game5{" +
                "playerList=" + playerList +
                '}';
    }
}
