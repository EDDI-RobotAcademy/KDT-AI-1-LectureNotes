package practice.dice3;
import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
public class Player {  // 플레이어 2명만 생성
    final private int HOW_MANY_PLAYERS = 2;
    final private List<Player> playerList = new ArrayList<>();
    public Player (int playerNumber) {
        for (int i = 0; i < HOW_MANY_PLAYERS; i++) {
            playerList.add(new Player(i + 1));
            System.out.println("플레이어" + playerList.get(i));
        }
    }
    @Override
    public String toString() {
        return "Player{" +
                "playerList=" + playerList +
                '}';
    }
}