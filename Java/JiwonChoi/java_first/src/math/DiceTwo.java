package math;

public class DiceTwo {

    public  static void main(String[] args) {
//        final int START = 1;
//        final int END = 6;
        final int MAX = 6;
        final int MIN = 1;

        final int RandomDice1 = (int)(Math.random() * 6) + 1;
        final int RandomDice2 = (int)(Math.random() * 6) + 1;

        int DiceSum = RandomDice1 + RandomDice2;
        int number1 = DiceSum % 4; //4로 나누고난 나머지값

        if(number1 == 0) {
            System.out.println("주사위의 합은 " + DiceSum + "이며 승리입니다.");
        } else {
            System.out.println("주사위의 합은 " + DiceSum + "이며 패배입니다.");
        }
//        System.out.println(RandomDice1);
//        System.out.println(RandomDice2);
//        System.out.println(DiceSum);
//        System.out.println(number1);

    }
}
