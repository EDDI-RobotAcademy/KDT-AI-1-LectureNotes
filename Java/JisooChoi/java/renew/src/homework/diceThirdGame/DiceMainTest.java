package homework.diceThirdGame;

public class DiceMainTest {
    public static void main(String[] args) {
        DiceGame game = new DiceGame();
        game.playGame();

        DicePlayer winner = game.win(game.player1, game.player2);
        System.out.println(game);

        System.out.println("승리자는 "+winner.name+"입니다.");
    }
}
