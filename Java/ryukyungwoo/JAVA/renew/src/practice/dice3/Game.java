package practice.dice3;

import java.util.List;

class FirstDiceDecision {
    final private int diceSelectedNumber = 0;
    final private List firstDecisionNumber;
    final private List firstSelectedDecisionNumber;
    public FirstDiceDecision () {
        Player player = new Player();
        firstDecisionNumber =
      player.playerNumberList.get(diceSelectedNumber);
        firstSelectedDecisionNumber = firstDecisionNumber.get(diceSelectedNumber);
    }

}
public class Game {
    public static void main(String[] args) {
        System.out.println(new FirstDiceDecision());
    }
}
