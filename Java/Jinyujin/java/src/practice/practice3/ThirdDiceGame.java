package practice.practice3;

// 친구와 1:1게임
// 주사위 3개
// 첫 번째 주사위가 짝수면 나머지 2개를 굴릴 수 있음
// 세 번째 주사위는 특수 기능이 존재
// 숫자가 1이면 친구에게 3점 훔치기(추후 광역 공격)
// 숫자가 3이면 자가 버프 2점
// 숫자가 4라면 무조건 패배

public class ThirdDiceGame {
    public static void main(String[] args) {

        Game game = new Game();
        game.playGame();
        game.findResult();
        game.checkWinner(); // player name이 둘 다 null 값으로 발생하는 문제
        // STEAL 이상하게 실행되는 문제
    }
}
