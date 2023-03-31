package practice.dice3;
import java.util.ArrayList;
import java.util.List;
class SelectedDice { // 원하는 순서의 주사위 숫자 가져오기
    final private int selectedDiceNumber; // 원하는 순서의 주사위 숫자

    public SelectedDice (int i) {
        DiceRolling diceRolling = new DiceRolling();
        selectedDiceNumber = diceRolling.diceList.get(i);
    }

    public int getSelectedDiceNumber() {
        return selectedDiceNumber;
    }

    @Override
    public String toString() {
        return "SelectedDice{" +
                "selectedDiceNumber=" + selectedDiceNumber +
                '}';
    }

    public static void main(String[] args) {
        System.out.println(new SelectedDice(1));
    }

}

public class DiceRolling { // 3번 굴리는걸 아예 따로 빼서 만듬
    final private int HOW_MANY_ROLL_DICE= 3; // 얼마나 굴릴지
    List<Integer> diceList = new ArrayList<>();
    public DiceRolling () {
        for (int i = 0; i < HOW_MANY_ROLL_DICE; i++) {
            Dice dice = new Dice();
            diceList.add(dice.getDiceNumber());
        }
    }
    public DiceRolling(List<Integer> diceList) {
        this.diceList = diceList;
    }
}