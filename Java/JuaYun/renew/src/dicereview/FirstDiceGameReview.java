package dicereview;

import dice.Player;
import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;
class RandomDiceList {
    private int MAX = 6;
    private int MIN = 1;
    private int diceNumber;
    List<Integer> diceList = new ArrayList<>();

    public RandomDiceList(int diceNumber) {
        this.diceNumber = diceNumber;

        // int tmpDiceNumber 커스텀랜덤을 int로 받기위해 생성
        for (int i = 0; i < diceNumber; i++) {
            int tmpDiceNumber = CustomRandom.generateNumber(MAX,MIN);
            diceList.add(tmpDiceNumber);
        }
    }
    public List<Integer> getDiceList() {
        return diceList;
    }

    @Override
    public String toString() {
        return "RandomDice{" +
                "diceList=" + diceList +
                '}';
    }
}
public class FirstDiceGameReview {
    public static void main(String[] args) {

        PlayerList playerList = new PlayerList();
        System.out.println(playerList);
    }
}
