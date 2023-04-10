package problems.prob27;

import customLibrary.diceGame.DiceGame;

public class Problem27 {
    public static void main(String[] args) {
        // 27 ~ 30까지 모두 완료
        DiceGame game = new DiceGame();
        System.out.println("처음 주사위 굴린 상태: ");
        System.out.println(game);

        game.applyDiceAbility();
        System.out.println("최종 상태: ");
        System.out.println(game);

        game.printRank();
    }
}
