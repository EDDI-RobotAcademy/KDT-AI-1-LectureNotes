package practice.dice3;


public class Player {
    final private int HOW_MANY_PLAYERS = 2;
    private Player player;
    public Player () {
        for (int i = 0; i < HOW_MANY_PLAYERS; i++) {
            this.player = new Dice();
        }
    }
}
