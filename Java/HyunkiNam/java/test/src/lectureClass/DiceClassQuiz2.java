package lectureClass;
import java.util.Arrays;

class Game2 {
    final int total_score;
    final int diceCount = 4;
    final int[] diceArray = new int[diceCount];
    public Game2(){
        for(int i=0; i<diceCount; i++){
            diceArray[i] = new Dice2().getDiceNumber();
        }
        this.total_score = new Score2(diceArray).getTotalScore();
    }

    @Override
    public String toString() {
        return "주사위 눈=" + Arrays.toString(diceArray) +
                ", 합계=" + total_score;
    }

    final int winner_Condition1 = 3;
    final int winner_Condition2 = 4;

    public void chkWin(){
        if(total_score % winner_Condition1 == 0 || total_score % winner_Condition2 ==0){
            System.out.println("승리!");
        }
        else
            System.out.println("패배..");
    }
}

class Dice2 {
    final int MIN = 1;
    final int MAX = 6;
    final int diceNumber;
    public Dice2(){
        this.diceNumber =  (int)(Math.random() * (MAX-MIN+1)) + MIN;//randomDiceValue;
    }
    public int getDiceNumber() {
        return diceNumber;
    }
}

class Score2 {
    final int totalScore;

    public int getTotalScore() {
        return totalScore;
    }

    int tmpScore =0;
    public Score2(int[] diceArray) {
        for(int i=0; i< diceArray.length; i++){
            tmpScore += diceArray[i];
        }

        this.totalScore = tmpScore;
    }
}
public class DiceClassQuiz2 {
    public static void main(String[] args) {
        Game2 game2 = new Game2();
        System.out.println(game2);
        game2.chkWin();
    }
}