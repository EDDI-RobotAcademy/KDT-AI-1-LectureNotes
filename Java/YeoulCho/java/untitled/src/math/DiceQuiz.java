package math;

public class DiceQuiz {
    public static void main(String[] args) {
        final int START = 0;
        final int END = 10;
        final int MAX = 6;
        final int MIN = 1;

        final int randomNumber = (int)(Math.random() * 10) + 1;

        int randomValue = 0;
        int dice1=0;
        int dice2=0;
        int sum_dice = dice1 + dice2;

        for (int i = START; i < END; i++) {
            dice1 = (int) (Math.random() * (MAX - MIN + 1)) + MIN; //1~6
            dice2 = (int) (Math.random() * (MAX - MIN + 1)) + MIN;
            System.out.println("i=" + i + ", dice1 = " + dice1 + ", dice2 = " +dice2);
        }
            System.out.println(sum_dice);

        if(sum_dice %4 == 0) {
             System.out.println( "승리");
        }else {
             System.out.println("패배");
        }
    }
}
