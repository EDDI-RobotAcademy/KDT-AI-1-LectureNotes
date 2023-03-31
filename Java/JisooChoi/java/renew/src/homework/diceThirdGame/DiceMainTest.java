package homework.diceThirdGame;

public class DiceMainTest {
    public static void main(String[] args) {
        DiceGame game = new DiceGame(); //게임객체 생성
        game.gamePlay();

        String winnerName = "";
        winnerName = game.winner();

        // ★ 구현해야 할 부분
        // 1. 3번째 주사위 가지고 게임하기
        // 2. 마지막 총 점을 가지고 winner 찾기
    }
}
