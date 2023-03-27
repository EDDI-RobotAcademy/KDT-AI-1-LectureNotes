package homework;

public class Homework2 {
    public static void main(String[] args) {

        final int MAX=6;
        final int MIN=1;



        final int Dice1= (int)(Math.random()*MAX)+MIN;
        final int Dice2= (int)(Math.random()*MAX)+MIN;

        System.out.println("첫번째 주사위 값은 =" +Dice1);
        System.out.println("첫번째 주사위 값은 =" +Dice2);

        int result=Dice1+ Dice2;
        System.out.println("두 주사위의 함 ="+result);

        if(result%4==0){
            System.out.println("승리");
        }
        else{
            System.out.println("패배");
        }
    }
}


