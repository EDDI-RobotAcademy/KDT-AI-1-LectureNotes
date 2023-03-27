package math;

public class DiceQuiz {
    public static void main(String[] args) {
        final int MAX = 6;
        final int MIN = 1;

        int dice1 = (int)(Math.random() * 6) + 1;
        int dice2 = (int)(Math.random() * 6) + 1;

        int sum_dice = dice1 + dice2;


        System.out.println(sum_dice);

        if(sum_dice %4 == 0) {
             System.out.println("4의 배수라면 승리");
        }else {
             System.out.println("4의 배수가 아니라면 패배");
        }
    }
}
