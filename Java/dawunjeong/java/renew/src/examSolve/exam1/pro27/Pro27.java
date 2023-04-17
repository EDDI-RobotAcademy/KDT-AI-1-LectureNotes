package examSolve.exam1.pro27;

import examSolve.exam1.customLibrary.diceGame.DiceGame;

// 문제 27번부터 30번
public class Pro27 {
    public static void main(String[] args) {
        DiceGame game = new DiceGame();

        // applyDiceAbility 메소드를 사용하기 전의 상태를 출력
        System.out.println("처음 주사위 굴린 상태: ");
        System.out.println(game);

        // 게임 시작
        game.applyDiceAbility();
        System.out.println("최종 상태: ");
        System.out.println(game);

        // rank 출력
        game.printRank();
    }
}
