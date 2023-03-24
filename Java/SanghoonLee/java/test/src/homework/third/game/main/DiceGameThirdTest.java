package homework.third.game.main;

import homework.third.game.component.Player;

// 친구 <- 추후 다수의 Player로 확장 가능성이 존재
// 주사위
// 점수
// 게임
class ThirdDiceGame {
    final private int PLAYER_NUM = 2;
    final private Player[] playerArray = new Player[PLAYER_NUM];

    public ThirdDiceGame() {
        for (int i = 0; i < PLAYER_NUM; i++) {
            playerArray[i] = new Player("플레이어" + (i + 1));
            System.out.println(playerArray[i]);
        }
    }

    public void playGame() {

    }
}

public class DiceGameThirdTest {
    public static void main(String[] args) {
        ThirdDiceGame game = new ThirdDiceGame();
        game.playGame();
    }
}
