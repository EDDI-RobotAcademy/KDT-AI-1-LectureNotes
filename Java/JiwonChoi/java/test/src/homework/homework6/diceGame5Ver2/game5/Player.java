package homework.homework6.diceGame5Ver2.game5;

import java.util.ArrayList;
import java.util.Arrays;

import static homework.homework6.diceGame5Ver2.game5.Dice.diceCount;
import static homework.homework6.diceGame5Ver2.game5.Dice.getDiceSum;

public class Player {   //플레이어의 요소- 이름, 주사위배열, 이전점수, 이후점수}
    static String playerName;
    static int AfterScore;
    static Dice[] diceArray = new Dice[diceCount]; //다이스 총개수만큼의 배열 할당 현재 3개 ==> [ ][ ][ ]
//    int diceSum;

    static ArrayList<Player> playerList = new ArrayList<>(); //모든 플레이어의 모음

    public Player(String playerName) {  //플레이어 이름으로 플레이어 생성
        Player.playerName = playerName;
    }

    public static void playerAdd(String playerName) { //플레이어 이름입력하면
        playerList.add(new Player(playerName));//그 이름을 가진 플레이어 객체를 생성 + List에 추가
    }

    public static void setAfterScore(int afterScore) {
        AfterScore = afterScore;
    }

    @Override
    public String toString() {  //플레이어 출력시 문구
        return "PlayerName=" + playerName + '\n' +
                "Dice=" + Arrays.toString(diceArray) + '\n' +
                "DiceSum=" + getDiceSum() + '\n' +
                "TotalScore=" + AfterScore;
    }



}
