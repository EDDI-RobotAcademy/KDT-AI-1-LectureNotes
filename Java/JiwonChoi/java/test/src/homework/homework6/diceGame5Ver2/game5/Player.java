package homework.homework6.diceGame5Ver2.game5;
import java.util.Arrays;
import static homework.homework6.diceGame5Ver2.game5.Dice.diceCount;


public class Player {   //플레이어의 요소- 이름, 주사위배열, 이전점수, 이후점수}
    String playerName;
    Dice[] diceArray = new Dice[diceCount]; //다이스 총개수만큼의 배열 할당 현재 3개 ==> [ ][ ][ ]
    int AfterScore;
    Score playerScore;
    int myIndex;
    int targetIndex;

    public Dice[] getDiceArray() {
        return diceArray;
    }
    public void setDiceArray(Dice[] diceArray) {
        this.diceArray = diceArray;
    }

    public void setPlayerScore(Score playerScore) {
        this.playerScore = playerScore;
    }

    public Score getPlayerScore() {
        return playerScore;
    }

    public Player(String playerName) {  //플레이어 이름으로 플레이어 생성
        this.playerName = playerName;
    }

    public void setMyIndex(int myIndex) {
        this.myIndex = myIndex;
    }

    public int getMyIndex() {
        return myIndex;
    }

    public void setTargetIndex(int targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public String toString() {  //플레이어 출력시 문구
        return  "PlayerName=" + playerName + '\n' +
                "Dice=" + Arrays.toString(diceArray) + '\n' +
                playerScore +
                "TotalScore=" + AfterScore + '\n';
    }

}
