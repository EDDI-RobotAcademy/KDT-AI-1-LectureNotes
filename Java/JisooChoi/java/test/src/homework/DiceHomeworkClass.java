package homework;

class Dice{
    // 필드
    final int diceNumber;
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
    final private int totalScore1;
    final private int totalScore2;
    final private int totalScore3;
    final private int totalScore4;

    // 생성자
    public Score(int totalScore1, int totalScore2, int totalScore3, int totalScore4){
        this.totalScore1 = totalScore1;
        this.totalScore2 = totalScore2;
        this.totalScore3 = totalScore3;
        this.totalScore4 = totalScore4;
    }

    // 메서드
   public int getTotalScore(){
       return this.totalScore1 + this.totalScore2 + this.totalScore3 + this.totalScore4;
   }
}

class Game{
    // 필드
    final private int DICE_VICTORY_CONDITION1 = 3;
    final private int DICE_VICTORY_CONDITION2 = 4;
    final private int totalScore;

    // 생성자
    public Game(int totalScore){
        this.totalScore = totalScore;
    }

    // 메서드
    public void getTotalScore() {
        if((this.totalScore % DICE_VICTORY_CONDITION1 == 0) || (this.totalScore % DICE_VICTORY_CONDITION2 == 0)){
            System.out.println("승리 !");
        }
        else System.out.println("패배 !");
    }
}
public class DiceHomeworkClass {
    public static void main(String[] args) {
        // 주사위 객체 생성
        final Dice dice1 = new Dice();
        final Dice dice2 = new Dice();
        final Dice dice3 = new Dice();
        final Dice dice4 = new Dice();
        System.out.println("각 주사위의 값은 ? 첫 번째: "+dice1.getDiceNumber()+", 두 번째: "+dice2.getDiceNumber()+", 세 번째: "+dice3.getDiceNumber()+", 네 번째: "+dice4.getDiceNumber());

        // 점수 객체 생성
        final Score score = new Score(dice1.diceNumber, dice2.diceNumber, dice3.diceNumber, dice4.diceNumber);
        System.out.println("총 더한 값은 ? "+score.getTotalScore());

        // 게임 객체 생성
        final Game game = new Game(score.getTotalScore());
        game.getTotalScore();
    }
}