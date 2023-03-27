package test;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        final int RANDOM1 = (int)(Math.random() * 6) +1;
            System.out.println("RANDOM1 = " + RANDOM1);
        final int RANDOM2 = (int)(Math.random() * 6) +1;
            System.out.println("RANDOM2 = " + RANDOM2);

              int sum = RANDOM1 + RANDOM2;
                    System.out.println("sum = " + sum);

         if((sum & 4) ==0)
             System.out.println("승리하였습니다");
         else if ((sum % 4) != 0)
             System.out.println("패배하였습니다.");


         }



    }









