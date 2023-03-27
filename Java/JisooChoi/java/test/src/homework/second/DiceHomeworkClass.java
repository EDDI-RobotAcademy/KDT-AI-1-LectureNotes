package homework.second;

class Dice{
    // 필드
    final private int diceNumber;
    final private int MAX = 6;
    final private int MIN = 1;

    // 생성자
    public Dice(){
        this.diceNumber = (int)(Math.random() * MAX) +MIN;
    }

    // 메서드
    public int getDiceNumber(){
        return diceNumber;
    }
}

class Score{
    // 필드
    final private int totalScore;
    final private int DICE_VICTORY_CONDITION1 = 3;
    final private int DICE_VICTORY_CONDITION2 = 4;

    // 생성자
    public Score(int totalScore){
        this.totalScore = totalScore;
    }

    // 메서드
   public void getTotalScore(){
       if((this.totalScore % DICE_VICTORY_CONDITION1 == 0) || (this.totalScore % DICE_VICTORY_CONDITION2 == 0)){
           System.out.println("승리 !");
       }
       else System.out.println("패배 !");
   }
}

class Game{
    // 필드
    final private int MAX_DiCE = 4;
    final private Score score;
    final private Dice[] diceArray;             // 객체 배열 선언

    // 생성자
    public Game(){
        this.diceArray = new Dice[MAX_DiCE];   // 객체 배열의 공간 할당
        int diceNumberSum = 0;

        for(int i = 0; i < diceArray.length; i++){
            diceArray[i] = new Dice();         // 객체 배열의 크기 할당

            // 누적값 더하기
            diceNumberSum += diceArray[i].getDiceNumber();
        }
        this.score = new Score(diceNumberSum);
    }

    // 메서드
    public void checkWin () {   // game.checkWin을 하면 score의 메서드로 넘어간다.
        score.getTotalScore();
    }
}
public class DiceHomeworkClass {
    public static void main(String[] args) {
        // 게임 객체 생성
        Game game = new Game();
        game.checkWin();
    }
}