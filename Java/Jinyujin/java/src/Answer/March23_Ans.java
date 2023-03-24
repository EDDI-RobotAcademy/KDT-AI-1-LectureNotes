package Answer;

// 친구 <- 추후 다수의 Player로 확장 가능성이 존재
// 주사위
// 점수
// 게임

import Answer.March23.Player;

class ThirdDiceGame {
    // 일단 player 클래스에서 player만 만든 상태
    final private int PLAYER_NUM = 2;
    final private Player[] playerArray = new Player[PLAYER_NUM];

    public ThirdDiceGame() {
        for (int i = 0; i < PLAYER_NUM; i++) {
            playerArray[i] = new Player("플레이어" + (i + 1)); // player 클래스로 넘어가서 tostring 생성
            System.out.println(playerArray[i]);
        }
        // 여기까지 만들었을 때 player 2명 나타난걸 알 수 있다
        // 그리고 뭘 만들고 싶을까? -> game시작하겠다
    }

    public void playGame() {
        // 게임을 하려면? 주사위 필요
        // 주사위는 누가 갖고 있는게 나을까? public ThirdDiceGame() 혹은 player?
        // 모르겠으면 일단 다 넣어보자 (큰 상관 없다고 함)
    }
}
public class March23_Ans {
    public static void main(String[] args) {
        ThirdDiceGame game = new ThirdDiceGame();
        game.playGame(); // -> 먼저 이걸 만들고나면 playGame 메소드를 만들어야 겠다고 생각
    }
}
