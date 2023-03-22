package homework;
// 주사위 값
class Dice {
    final int MAX = 6;
    final int MIN = 1;
    final int diceNumber;
    public Dice() {
        this.diceNumber = (int)(Math.random() * MAX - MIN + 1) + MIN;
    }
    public int getDiceNumber(){
        return diceNumber;
    }
}
// 주사위 합
class Score {
    int totalScore;
    int diceNumber1;
    int diceNumber2;
    int diceNumber3;
    int diceNumber4;
    public Score(int diceNumber1, int diceNumber2, int diceNumber3, int diceNumber4) {
        this.totalScore = diceNumber1 + diceNumber2 + diceNumber3 + diceNumber4;
    }
    public int getTotalScore() {
        return totalScore;
    }
}
class Game{
    int winnerCondition1;
    int winnerCondition2;
    int totalScore;
    public Game (int winnerCondition1, int winnerCondition2,int totalScore) {
        if((totalScore % winnerCondition1 == 0) || (totalScore % winnerCondition2 == 0)) {
            System.out.println(+ winnerCondition1 + " 혹은 " + winnerCondition2 + "의 배수이므로 승리입니다.");
        } else {
            System.out.println(+ winnerCondition1 + " 혹은 " + winnerCondition2 + "의 배수가 아니므로 패배입니다.");
        }
    }
}
public class DiceHomework2 {
    public static void main(String[] args) {
        Dice dice1 = new Dice();
        Dice dice2 = new Dice();
        Dice dice3 = new Dice();
        Dice dice4 = new Dice();
        System.out.println("첫번째 주사위의 값 : " + dice1.diceNumber);
        System.out.println("두번째 주사위의 값 : " + dice2.diceNumber);
        System.out.println("세번째 주사위의 값 : " + dice3.diceNumber);
        System.out.println("네번째 주사위의 값 : " + dice4.diceNumber);
        System.out.println();

        Score score = new Score(dice1.diceNumber, dice2.diceNumber, dice3.diceNumber, dice4.diceNumber);
        System.out.println("주사위의 합은 " + score.totalScore + "입니다");
        System.out.println();

        Game game = new Game(3,4,score.totalScore);
    }
}