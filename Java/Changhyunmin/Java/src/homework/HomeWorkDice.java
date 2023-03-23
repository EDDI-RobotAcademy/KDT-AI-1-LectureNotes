package homework;
class Dice {
    final int MIN = 1;
    final int MAX = 6;
    final int diceNum1 = (int)(Math.random() * (MAX - MIN +1)) + MIN;
    final int diceNum2 = (int)(Math.random() * (MAX - MIN +1)) + MIN;
    final int diceNum3 = (int)(Math.random() * (MAX - MIN +1)) + MIN;
    final int diceNum4 = (int)(Math.random() * (MAX - MIN +1)) + MIN;

    final int diceSum = (diceNum1 + diceNum2 + diceNum3 + diceNum4);

    @Override
    public String toString() {
        return "첫번째 주사위: " + diceNum1 +"\n"+
                "두번째 주사위: " + diceNum2 +"\n"+
                "세번째 주사위: " + diceNum3 +"\n"+
                "네번째 주사위: " + diceNum4 ;
    }
}
class Score {
    final int WINNER1 = 3;
    final int WINNER2 = 4;
}
public class HomeWorkDice {
    public static void main(String[] args) {

        Dice dice = new Dice();
        Score score = new Score();

        System.out.println(dice);
        System.out.println("총 주사위의 값: " + dice.diceSum);

        if (dice.diceSum % score.WINNER1 == 0||dice.diceSum % score.WINNER2 == 0){
            System.out.println("승리하셨습니다!");
        }else {
            System.out.println("패배하셨습니다...");
        }
    }
}