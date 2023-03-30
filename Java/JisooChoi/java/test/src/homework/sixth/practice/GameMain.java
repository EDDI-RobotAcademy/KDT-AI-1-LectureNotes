package homework.sixth.practice;

public class GameMain {
    public static void main(String[] args) {
        GameDice gameDice = new GameDice();
        gameDice.addDiceArray();
        System.out.println(gameDice);
        gameDice.gamePlay();

        GameDice gameDice2 = new GameDice();
        gameDice2.addDiceArray();
        System.out.println(gameDice2);
        gameDice2.gamePlay();
    }
}
