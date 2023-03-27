package homework;

class Dice {
    private int diceNumber1;
    private int diceNumber2;
    private int diceNumber3;
    private int diceNumber4;
    int diceNumberSum;

    Dice() {
            final int MIN = 1;
            final int MAX = 6;
            diceNumber1 = (int) (Math.random() * MAX) + MIN;
            diceNumber2 = (int) (Math.random() * MAX) + MIN;
            diceNumber3 = (int) (Math.random() * MAX) + MIN;
            diceNumber4 = (int) (Math.random() * MAX) + MIN;
            System.out.println("첫 번째 주사위 = " + diceNumber1);
            System.out.println("두 번째 주사위 = " + diceNumber2);
            System.out.println("세 번째 주사위 = " + diceNumber3);
            System.out.println("네 번째 주사위 = " + diceNumber4);

            diceNumberSum = diceNumber1 + diceNumber2 + diceNumber3 + diceNumber4;
            System.out.println("4개 주사위의 합은 " + diceNumberSum + "입니다.");
        }
        public void matchResult (){
            final int WINNER_DECISION_NUMBER1 = 3;
            final int WINNER_DECISION_NUMBER2 = 4;

            if (diceNumberSum % WINNER_DECISION_NUMBER1 == 0 || diceNumberSum % WINNER_DECISION_NUMBER2 == 0) {
                System.out.println("승리!");
            } else {
                System.out.println("패배!");
            }
        }
    }

public class March22 {
    public static void main(String[] args) {
        Dice dice = new Dice();
        dice.matchResult();
    }

}
