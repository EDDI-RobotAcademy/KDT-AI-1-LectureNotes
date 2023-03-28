package homework.fifth;
import java.util.ArrayList;
import java.util.List;
public class fourthPlayer {

    final private int MAX_DICE_NUM = 3; // 주사위를 3개 갖고 있어
    final private String name; // 그들의 이름이 있어
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
            // gameDices[i] = new GameDice(); // gameDices라는 배열에 순차적으로 게임다이스를 넣을거야, 게임다이스의 값은 랜덤 숫자 하나야
            gameDice.add(new fourthDice()); // 리스트형으로 gameDice라는 리스트에 값을 넣을건데, 다이스 클래스에서 가져온 값을 넣을거야
            // diceNumberSum += gameDices[i].getDiceNumber(); // 그 다이스 넘버들을 더할거
            diceNumberSum += gameDice.get(i).getDiceNumber();
            // if(gameDices[0].getDiceNumber() % 2 == 1){ // 0번째 배열값이 홀수라면
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