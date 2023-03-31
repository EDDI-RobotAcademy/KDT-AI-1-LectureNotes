package practice.dice3;

import java.util.ArrayList;
import java.util.List;
public class Game {
    List<Player> playerList = new ArrayList<>();
    // 12. 일단 플레이어도 리스트가 필요하니까 만들기
    final private int MAX_PLAYER_NUMBER = 2;
    final private int diceSum = 0;
    public Game() {
        for (int i = 0; i < MAX_PLAYER_NUMBER; i++) {
            playerList.add(new Player());
             = playerList.get(i);
        }
    }
    // 13. 플레이어와 주사위 연결시키기 성공
    // 14. 이제 필요한 것은 플레이어 숫자 판별과 주사위 숫자 판별

    @Override
    public String toString() {
        return "Game{" +
                "playerList=" + playerList +
                '}';
    }
}
