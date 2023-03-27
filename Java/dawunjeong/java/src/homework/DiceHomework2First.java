package homework;
// 주사위 값
class Dice {
    final int MAX = 6;
    final int MIN = 1;
    int diceNumber = 0;

    public Dice() {
        this.diceNumber = (int)(Math.random() * MAX - MIN + 1) + MIN;
    }

    public int getDiceNumber() {
        return diceNumber;
    }
}

// 주사위 합
class Score {
    int totalScore;
    final int MAX_DICE = 0;
    final int[] diceNumberArr = new int[MAX_DICE];
    int diceNumber;


    public Score(int MAX_DICE) {
        for (int i = 0; i < MAX_DICE; i++) {
            diceNumberArr[i] = diceNumber;
            System.out.println((i + 1) + "번째 주사위의 값: " + diceNumberArr[i]);
            totalScore += diceNumber;
        }

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
public class DiceHomework2First {
    public static void main(String[] args) {
        Dice dice = new Dice();
        System.out.println();

        Score score = new Score(4);
        System.out.println("주사위의 합은 " + score.totalScore + "입니다");
        System.out.println();

        Game game = new Game(3,4,score.totalScore);
    }
}