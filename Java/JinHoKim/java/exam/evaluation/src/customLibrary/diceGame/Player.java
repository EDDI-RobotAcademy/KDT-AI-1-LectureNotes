package customLibrary.diceGame;

public class Player implements Comparable<Player> {

    private String name;
    private final Dice dice;

    public Player(String name) {
        this.name = name;
        this.dice = new Dice();
    }

    public String getName() {
        return name;
    }

    public Dice getDice() {
        return dice;
    }

    @Override
    public int compareTo(Player otherPlayer) {
        final int otherPlayerDiceNumber = otherPlayer.getDice().getDiceNumber();
        final int currentPlayerDiceNumber = this.getDice().getDiceNumber();

        if (otherPlayerDiceNumber < currentPlayerDiceNumber) {
            return 1;
        } else if (otherPlayerDiceNumber > currentPlayerDiceNumber) {
            return -1;
        }

        return 0;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", dice=" + dice +
                '}' + '\n';
    }
}
