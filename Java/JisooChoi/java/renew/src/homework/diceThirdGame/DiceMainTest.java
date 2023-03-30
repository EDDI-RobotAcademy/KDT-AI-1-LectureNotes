package homework.diceThirdGame;

public class DiceMainTest {
    public static void main(String[] args) {
        DiceGame game = new DiceGame(); //게임객체 생성
        game.gamePlay();
//        game.winner();
        System.out.println(game);

        // ★ 구현해야 할 부분
        // 1. 3번째 주사위 가지고 게임하기
        // 2. 각 숫자들 상수로 만들어주기 + 다른 변수들 final 처리
        // 3. 마지막 총 점을 가지고 winner 찾기
    }
}
