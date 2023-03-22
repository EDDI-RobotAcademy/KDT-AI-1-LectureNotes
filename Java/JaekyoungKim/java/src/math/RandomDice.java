package math;

public class RandomDice {
    public static void main(String[] args) {

        final int MAX =6;
        final int MIN =1;
        int randomDice1 =0;
        int randomDice2 =0;

        randomDice1= (int)(Math.random() * (MAX - MIN + 1)) + MIN;

        randomDice2= (int)(Math.random() * (MAX - MIN + 1)) + MIN;


        int diceSum=(randomDice1+randomDice2);
        int diceDivison=(randomDice1+randomDice2)%4;

        switch (diceDivison){
            case 0:
                System.out.println("Dice 1의 값은 "+randomDice1+" Dice 2의 값은 "+randomDice2+"로 합한 숫자 "+diceSum+"는 4의 배수이므로 승리입니다.");
                break;
            default:
                System.out.println("Dice 1의 값은 "+randomDice1+" Dice 2의 값은 "+randomDice2+"로 합한 숫자 "+diceSum+"는 4의 배수가 아니므로 패배입니다.");
                break;
        }


    }



}
