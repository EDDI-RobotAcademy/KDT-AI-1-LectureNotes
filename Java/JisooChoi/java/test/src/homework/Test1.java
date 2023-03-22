package homework;

public class Test1 {
    public static void main(String[] args) {
        final int MAX = 6;
        final int MIN = 1;
        final int DICE_DECIDE_VICTORY = 4;

        final int DiceNumber1 = (int)(Math.random() * MAX) +MIN;
        final int DiceNumber2 = (int)(Math.random() * MAX) +MIN;

        final int randomDiceSum = DiceNumber1 + DiceNumber2;

        if((randomDiceSum % DICE_DECIDE_VICTORY)== 0){
            System.out.println("결과 : "+randomDiceSum);
            System.out.println("첫 번째 주사위 값: "+DiceNumber1+", 두 번째 주사위 값: "+DiceNumber2+" => 성공 !");
        }
        else{
            System.out.println("결과 : "+randomDiceSum);
            System.out.println("첫 번째 주사위 값: "+DiceNumber1+", 두 번째 주사위 값: "+DiceNumber2+" => 실패 !");
        }
    }
}
