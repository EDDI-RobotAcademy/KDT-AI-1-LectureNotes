package homework;

class Dice2{
    final int MAX_DICE = 4; // 주사위의 개수
    final int[] diceNumber = new int[MAX_DICE]; // 각 주사위의 값
    int totalScore;

    final int MAX = 6;
    final int MIN = 1;

    public void diceNumber() {
        for (int i = 0; i < MAX_DICE; i++) {
            diceNumber[i] = (int) (Math.random() * MAX - MIN + 1) + MIN;
            System.out.println((i+1) + "번째 주사위의 값: " + diceNumber[i]);
            totalScore += diceNumber[i];
        }
    }

    public int totalScore(){
        return totalScore;
    }

}
public class DiceHomework2Second {
    public static void main(String[] args) {

        int winnerCondition1 = 3;
        int winnerCondition2 = 4;

        Dice2 dice2 = new Dice2();
        dice2.diceNumber();
        System.out.println("주사위 값의 총합은 " + dice2.totalScore + " 입니다.");
        System.out.println();

        if((dice2.totalScore % winnerCondition1 == 0) || (dice2.totalScore % winnerCondition2 == 0)) {
            System.out.println(+ winnerCondition1 + " 혹은 " + winnerCondition2 + "의 배수이므로 승리입니다.");
        } else {
            System.out.println(+ winnerCondition1 + " 혹은 " + winnerCondition2 + "의 배수가 아니므로 패배입니다.");
        }
    }

}
