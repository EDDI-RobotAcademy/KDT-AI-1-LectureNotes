package math;

public class RandomDice {
    public static void main(String[] args) {

        final int MAX =6;
        final int MIN =1;
        final int randomDice1 =(int)(Math.random() * (MAX - MIN + 1)) + MIN;
        final int randomDice2 =(int)(Math.random() * (MAX - MIN + 1)) + MIN;
        final int diceSum=(randomDice1+randomDice2);
        final int diceDivison=(diceSum)%4;

        System.out.println("주사위 1의 값은 "+randomDice1);
        System.out.println("주사위 2의 값은 "+randomDice2);

        switch (diceDivison){
            case 0:
                System.out.println("Dice 1의 값은 "+randomDice1+" Dice 2의 값은 "+randomDice2+"로 합한 숫자 "+diceSum+"는 4의 배수이므로 승리입니다.");
                break;
            default:
                System.out.println("주사위 1의 값은 "+randomDice1+" 주사위 2의 값은 "+randomDice2+"로 합한 숫자 "+diceSum+"는 4의 배수가 아니므로 패배입니다.");
                break;
        }


    }



}
