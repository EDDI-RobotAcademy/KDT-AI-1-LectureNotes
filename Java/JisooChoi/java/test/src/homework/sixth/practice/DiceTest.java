package homework.sixth.practice;

public class DiceTest {
    public static void main(String[] args) {
        DiceGame diceGame = new DiceGame();

        Player cjs = new Player("cjs");
        Player phj = new Player("phj");

        Player winner = diceGame.playDiceGame(cjs, phj);

        System.out.println("승자는 "+winner.getName()+"입니다.");
    }
}
