package homework.ranDice4.component;

public class Player {
    final private int MAX_DICE_NUM = 3;
    final private String name;
    final GameDice[] gameDices = new GameDice[MAX_DICE_NUM];
    final private GameScore gamescore;

    public Player(String name) {
        this.name  = name ;

        int diceNumberSum = rollDice();
        gameScore = new GameScore(diceNumberSum);
    }
}
