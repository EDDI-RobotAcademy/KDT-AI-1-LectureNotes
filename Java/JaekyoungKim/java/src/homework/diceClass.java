package homework;

import java.util.Arrays;
class Dice{
    public int getNum() {
        return num;
    }

    public Dice(int num) {
        this.num = num;
    }

    private final int num;
    public Dice() {
        final int MAX =6;
        final int MIN =1;
         this.num =(int)(Math.random() * (MAX - MIN + 1)) + MIN;
    }
    @Override
    public String toString(){
        return "주사위의 값은 "+num+" 입니다.";
    }
}

public class diceClass {
    public static void main(String[] args) {


        final Dice dice1= new Dice();
        final Dice dice2= new Dice();
        final Dice dice3= new Dice();
        final Dice dice4= new Dice();
        final int diceSum=(dice1.getNum()+dice2.getNum()+dice3.getNum()+dice4.getNum());
        int diceDivison1=diceSum%3;
        int diceDivison2=diceSum%4;

        System.out.println(dice1);
        System.out.println(dice2);
        System.out.println(dice3);
        System.out.println(dice4);
        System.out.println("네 주사위의 합은 "+diceSum+" 입니다.");

        if ((diceDivison1==0)||(diceDivison2==0)){
            System.out.println("네 주사위의 합은 3 혹은 4의 배수로 승리하였습니다.");
        }
        else {
            System.out.println("네 주사위의 합이 3과 4의 배수가 아니므로 패배하였습니다.");
        }
}}
