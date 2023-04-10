package homework.fifth.diceList;

public class diceRolling {
    private DiceEnum diceEnum;

    public diceRolling(DiceEnum diceEnum) {
        this.diceEnum = diceEnum;
    }

    @Override
    public String toString() {
        return "diceRolling{" +
                "diceEnum=" + diceEnum +
                '}';
    }
}
