package homework;
final class Dice {
    final private int MIN = 1;
    final private int MAX = 6;
    final private int WINNER1 = 3;
    final private int WINNER2 = 4;

    final int diceNum1 = (int)(Math.random() * (MAX - MIN +1)) + MIN;
    final int diceNum2 = (int)(Math.random() * (MAX - MIN +1)) + MIN;
    final int diceNum3 = (int)(Math.random() * (MAX - MIN +1)) + MIN;
    final int diceNum4 = (int)(Math.random() * (MAX - MIN +1)) + MIN;

    final int diceSum = (diceNum1 + diceNum2 + diceNum3 + diceNum4);

    public boolean Win(){
        if (diceSum % WINNER1 == 0 || diceSum % WINNER2 == 0){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "첫번째 주사위: " + diceNum1 +"\n"+
                "두번째 주사위: " + diceNum2 +"\n"+
                "세번째 주사위: " + diceNum3 +"\n"+
                "네번째 주사위: " + diceNum4 ;
    }
}
public class HomeWorkDice {
    public static void main(String[] args) {

        Dice dice = new Dice();

        System.out.println(dice);
        System.out.println("총 주사위의 값: " + dice.diceSum);
        System.out.println(dice.Win()? "승리" : "패배");
    }
}