package homework.DiceYu;

public class Game {
    public static void main(String[] args) {
        Player player1 =new Player("플레이어1");
        Player player2 =new Player("플레이어2");
        player1.rollDice();
        player2.rollDice();
        player1.calculateTotalScore(player2.score);
        player2.calculateTotalScore(player1.score);
        System.out.println(player1);
        System.out.println(player2);
    }
}
