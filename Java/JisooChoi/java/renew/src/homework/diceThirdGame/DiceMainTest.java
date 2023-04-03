package homework.diceThirdGame;

public class DiceMainTest {
    public static void main(String[] args) {
        // 게임 객체 생성
        DiceGame game = new DiceGame();

        game.playGame();

        // ★ 여전히 두 플레이어 중 누가 공격자가 이고,
        //  공격당하는 사람이 되는지는 모르겠어서 임의로 설정
        game.thirdDiceGame(game.player1, game.player2);
        game.thirdDiceGame(game.player2, game.player1);

        DicePlayer winner = game.win(game.player1, game.player2);
        System.out.println(game);

        System.out.println("승리자는 "+winner.name+"입니다.");
    }
}
