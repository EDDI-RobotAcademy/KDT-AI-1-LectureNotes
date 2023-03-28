package homework.fifth;
import java.util.ArrayList;
import java.util.List;
public class fourthPlayer {

    final private int MAX_DICE_NUM = 3;
    final private String name;
    fourthGameScore gameScore;
    final private List<fourthDice> gameDice = new ArrayList<>();

    public fourthPlayer(String name) {

        this.name = name;
        int diceNumberSum = rollDice();
        gameScore = new fourthGameScore(diceNumberSum);

    }

    private int rollDice() {

        int diceNumberSum = 0;

        for(int i = 0; i < MAX_DICE_NUM; i++){
            gameDice.add(new fourthDice());
            diceNumberSum += gameDice.get(i).getDiceNumber();
            if(gameDice.get(0).getDiceNumber() % 2 == 1){
                break;
            }
        }
        return diceNumberSum;
    }

    public fourthDice getSelectedGameDice(int index) {
        return gameDice.get(index);
    }

    public fourthGameScore getGameScore() {
        return gameScore;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Player [name=" + name + '\'' +
                ", gameScore=" + gameScore + '\'' +
                ", gameDice=" + gameDice +
                "]";
    }

}