package homework2;

class Dice2 {
//    final int MAX_DICE = 4;
//    final int[] diceNumberArr = new int[MAX_DICE];

    private int diceNumber1;
    private int diceNumber2;
    private int diceNumber3;
    private int diceNumber4;
    final int MAX = 6;
    final int MIN = 1;
    final int WIN_DECISION_NUM1 = 4;
    final int WIN_DECISION_NUM2 = 3;
    static int diceNumberSum;


    Dice2() {
    }

    public void roll() { // 주사위 굴리고 나온 결과값 합 구하기
        diceNumber1 = (int)(Math.random() * (MAX - MIN + 1)) + MIN;
        diceNumber2 = (int)(Math.random() * (MAX - MIN + 1)) + MIN;
        diceNumber3 = (int)(Math.random() * (MAX - MIN + 1)) + MIN;
        diceNumber4 = (int)(Math.random() * (MAX - MIN + 1)) + MIN;
        diceNumberSum = diceNumber1 + diceNumber2 + diceNumber3 + diceNumber4;
        System.out.println("주사위 굴려서 합친값: " + diceNumberSum);
        totalScore();
    }

    public void totalScore() { // 합계를 통해 3의배수 또는 4의배수 일 경우 승리 출력
        if (diceNumberSum % WIN_DECISION_NUM1 == 0 || diceNumberSum % WIN_DECISION_NUM2 == 0) {
            System.out.println("승리!");
        } else {
            System.out.println("패배!");
        }
    }
}
public class SecondHomework {
    public static void main(String[] args) {
        Dice2 dice = new Dice2();
        dice.roll();
    }
}