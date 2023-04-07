package problems.prob27;

public class Player {
    final private String name;
    int diceNumber;

    public Player(String name) {
        this.name = name;
        diceNumber = new Dice().getDiceNumber();
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", diceNumber=" + diceNumber +
                '}';
    }
}
