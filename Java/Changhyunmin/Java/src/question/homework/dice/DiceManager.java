package question.homework.dice;

public class DiceManager {
    public static void main(String[] args) {
        DiceGame game = new DiceGame();
        System.out.println("점수 판정 이후");
        game.playGame();
        game.printResilt();
        game.checkWinner();
    }
}
