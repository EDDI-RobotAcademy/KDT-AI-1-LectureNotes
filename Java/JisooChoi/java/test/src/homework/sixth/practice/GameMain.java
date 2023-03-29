package homework.sixth.practice;

public class GameMain {
    public static void main(String[] args) {
//        Dice dice = new Dice();
//        System.out.println(dice);

        GameDice gameDice = new GameDice();
        gameDice.addDiceArray();
        System.out.println(gameDice);
    }
}
