package writerForm.diceGame;

public class DiceMainTest {
    public static void main(String[] args) {
        DiceGame game = new DiceGame();

        DicePlayer dog = new DicePlayer("dog");
        DicePlayer cat = new DicePlayer("cat");

        game.gamePlay(dog, cat); //게임시작
        DicePlayer winnerName = game.winner(dog, cat);

        System.out.println("승자는 "+ winnerName.name+"입니다.");

    }
}
