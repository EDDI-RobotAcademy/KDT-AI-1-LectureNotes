package homework.third.DiceGame3Practice;

import java.util.Arrays;

class Player{
//플레이어 뭐뭐 갖고있을꺼야? 이름, 주사위 3개, 주사위 숫자
    final private String Player_Name;
    final private int MAX_DICE_NUM = 3;
    final private Dice3[] gameDices = new Dice3[MAX_DICE_NUM];
    //final private GameScore gameScore;

    final int diceNumberSum;

    public Player(String player_Name) {
        this.Player_Name = player_Name;
        diceNumberSum = rollDice() ;

    }//이름에 대한것



    public String getPlayer_Name() {
        return Player_Name;
    }

    public int rollDice(){ // 주사위 배열에 주사위를 주겠다
        int diceNumberSum = 0; //주사위 처음 합은 0
        final int FIRST_DICE_INFO = 0;
        final int DECISION_EVEN = 2;
        final int ODD = 1;

        for(int i=0; i<MAX_DICE_NUM; i++){
            gameDices[i] = new Dice3();

            diceNumberSum += gameDices[i].getRandomDice();

            if (gameDices[FIRST_DICE_INFO].getRandomDice() % DECISION_EVEN == ODD){
                break;} //gameDices의 0번째 공간에 가져온 랜덤주사위 숫자를 2로 나눴을 때 0이라면 나와라



        }


/*            gameDices[i] = new Dice3(); // 주사위 배열의 i번째 공간에 새로운 주사위를 생성한다.
            diceNumberSum += gameDices[i].getRandomDice(); //diceNumberSum에 주사위배열의 랜덤다이스 숫자를 더해라


        } return diceNumberSum;
*/

        return diceNumberSum;
    }


    @Override
    public String toString() {
        return "Player{" +
                "Player_Name='" + Player_Name + '\'' +
                ", gameDices=" + Arrays.toString(gameDices) +
                ", diceNumberSum=" + diceNumberSum +
                '}';
    }
}

class Dice3 {
    //먼저 랜덤주사위를 만들자
    final private int randomDice;
    final private int MAX=6;
    final private int MIN=1;

    public Dice3() {
        this.randomDice = (int)((Math.random() * (MAX - MIN +1)) + MIN);
    }

    public int getRandomDice() {
        return randomDice;
    }

    @Override
    public String toString() {
        return "Dice3{" +
                "randomDice=" + randomDice +
                '}';
    }
}

class GameScore{
    private int GameScore;

    public GameScore(int totalGameScore) {
        this.GameScore = totalGameScore;
    }

    @Override
    public String toString() {
        return "GameScore{" +
                "GameScore=" + GameScore +
                '}';
    }
}
public class Game {
    public static void main(String[] args) {
        Player Player1 = new Player("ㅈㅇㄹ");
        Player Player2 = new Player("dfx");
        System.out.println(Player1);
        System.out.println(Player2);

        //플레이어 만들기

    }
}
