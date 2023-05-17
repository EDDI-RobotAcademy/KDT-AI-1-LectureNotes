package problems.prob27;

public class Player {
    final private String name;
    int diceNumber;
    int hp;

    public Player(String name) {
        this.name = name;
        diceNumber = new Dice().getRandomDiceNumber();
        hp = diceNumber;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDiceNumber() {
        return diceNumber;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", diceNumber=" + diceNumber +
                ", hp=" + hp +
                '}';
    }
}
