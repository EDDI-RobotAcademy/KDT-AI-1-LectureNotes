package practice.dice3.diceGame3BackLogPractice2.main;

import practice.dice3.diceGame3BackLogPractice2.diceGame.PlayDiceGame;

// 친구와 게임을 할 수 있습니다.
// 1:1 게임이라 가정하겠습니다.
// 주사위를 3개 굴립니다.
// 첫 번째 주사위가 짝수라면
// 두 번째 주사위와 세 번째 주사위를 굴릴 수 있습니다.
// 두 번째 주사위는 특수 기능이 별도로 존재하지 않습니다.
// 세 번째 주사위는 숫자 1인 경우 친구에게 점수를 3점 뺏을 수 있습니다.
// 숫자가 3인 경우엔 자신에게 2점을 가산합니다.
// 숫자가 4인 경우엔 무조건 패배하게 됩니다.
// 친구와 함께 플레이 할 수 있는 주사위 게임을 만들어주세요.
public class DiceGame3 {

    public static void main(String[] args) {
        final PlayDiceGame diceGame = new PlayDiceGame();
        diceGame.thidrDicePlay();
    }
}
