package homework.third;

import java.util.Arrays;

// 주사위의 랜덤값
class Dice2 {

    final private int MIN = 1;
    final private int MAX = 6;
    final private int diceNumber;
    public Dice2() {
        this.diceNumber = (int)(Math.random() * MAX - MIN + 1) + MIN;
    }
    public int getDiceNumber() {
        return diceNumber;
    }
}

// 주사위 값의 합
class Score {

    int MAX_DICE = 3;
    int diceSum;
    int [] diceNumberArray = new int[MAX_DICE];

    public Score() {
        for(int i = 0; i < MAX_DICE; i++) {
            diceNumberArray[i] = new Dice2().getDiceNumber();
            if(diceNumberArray[0] % 2 == 0){
                diceSum += diceNumberArray[i];
                continue;
            } else{
                diceSum = diceNumberArray[0];
                break;
            }
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(diceNumberArray);
    }
    public int getDiceSum() {
        return diceSum;
    }
}

// 3번째 주사위의 값에 따른 최종점수 계산
// 3번째 주사위가 4일 때는 모르겠습니다..
class ThirdValueCheck {

    Score score = new Score();

    int ThirdDice_player1 = score.diceNumberArray[2];
    int ThirdDice_player2 = score.diceNumberArray[2];

    int Total_player1;
    int Total_player2;

    public ThirdValueCheck(int Sum_player1, int Sum_player2, int ThirdDice_player1, int ThirdDice_player2) {
        if (ThirdDice_player1 == 1) {
            Sum_player1 += 3;
            Sum_player2 -= 3;
        }
        if (ThirdDice_player1 == 3) {
            Sum_player1 += 2;
        }
        if (ThirdDice_player2 == 1) {
            Sum_player1 -= 3;
            Sum_player2 += 3;
        }
        if (ThirdDice_player2 == 3) {
            Sum_player2 += 2;
        }
        this.Total_player1 = Sum_player1;
        this.Total_player2 = Sum_player2;
    }

    public int getTotal_player1() {
        return Total_player1;
    }

    public int getTotal_player2() {
        return Total_player2;
    }
}
class Game {
    public Game(String player1, String player2) {
        System.out.println(player1 + "의 주사위");
        Score scoreplayer1 = new Score();
        System.out.println(scoreplayer1.toString());
        System.out.println(player2 + "의 주사위");
        Score scoreplayer2 = new Score();
        System.out.println(scoreplayer2.toString());
        System.out.println();
        ThirdValueCheck thirdvaluechk = new ThirdValueCheck(scoreplayer1.getDiceSum(), scoreplayer2.getDiceSum(),
                scoreplayer1.diceNumberArray[2],scoreplayer2.diceNumberArray[2]);
        System.out.println(player1 + "의 최종 점수: " + thirdvaluechk.getTotal_player1());
        System.out.println(player2 + "의 최종 점수: " + thirdvaluechk.getTotal_player2());

        System.out.println();
        int Result_player1 = thirdvaluechk.getTotal_player1();
        int Result_player2 = thirdvaluechk.getTotal_player2();
        if(Result_player1 < Result_player2) {
            System.out.println(player2 + " 승리!");
        }
        if(Result_player1 > Result_player2) {
            System.out.println(player1 + " 승리!");
        }
        if(Result_player1 == Result_player2) {
            System.out.println("무승부");
        }
    }

}
public class ThirdHomeworkDice {
    public static void main(String[] args) {
        Game game = new Game("김자바", "이자바");
    }
}