package homework.first;

public class DiceHomework {
    public static void main(String[] args) {
        final int MAX = 6;
        final int MIN = 1;
        final int DICE_DECIDE_VICTORY = 4;

        final int diceNumber1 = (int)(Math.random() * MAX) +MIN;
        final int diceNumber2 = (int)(Math.random() * MAX) +MIN;

        final int randomDiceSum = diceNumber1 + diceNumber2;

        if((randomDiceSum % DICE_DECIDE_VICTORY)== 0){
            System.out.println("결과 : "+randomDiceSum);
            System.out.println("첫 번째 주사위 값: "+diceNumber1+", 두 번째 주사위 값: "+diceNumber2+" => 성공 !");
        }
        else{
            System.out.println("결과 : "+randomDiceSum);
            System.out.println("첫 번째 주사위 값: "+diceNumber1+", 두 번째 주사위 값: "+diceNumber2+" => 실패 !");
        }
    }
}
