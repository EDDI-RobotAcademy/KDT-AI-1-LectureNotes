package homework.Dice5Yu;

public class Play {
    public static void main(String[] args) {
    Game g1 =new Game();
    g1.addPlayer();
    g1.rollDice();
    g1.findThreeDice();
    g1.calculateTotalScore();
        System.out.println(g1.playList);
//    Game.PlayDice();
//    Game.

    }
}