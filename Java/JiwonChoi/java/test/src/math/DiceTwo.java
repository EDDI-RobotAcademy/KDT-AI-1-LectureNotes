package math;

public class DiceTwo {

    public  static void main(String[] args) {
        final int MAX = 6;
        final int MIN = 1;

        final int RandomDice1 = (int)(Math.random() * MAX) + MIN;
        final int RandomDice2 = (int)(Math.random() * MAX) + MIN;

        System.out.println("주사위1의 값은 " + RandomDice1 + "입니다.");
        System.out.println("주사위2의 값은 " + RandomDice2 + "입니다.");

        int DiceSum = RandomDice1 + RandomDice2;
        int number1 = DiceSum % 4; //4로 나누고난 나머지값

        if(number1 == 0) { //나머지가 0이면
            System.out.println("주사위의 합은 " + DiceSum + "이며 승리하셨습니다.");
        } else { //나머지가 0이 아니면
            System.out.println("주사위의 합은 " + DiceSum + "이며 패배하셨습니다.");
        }
    }
}
