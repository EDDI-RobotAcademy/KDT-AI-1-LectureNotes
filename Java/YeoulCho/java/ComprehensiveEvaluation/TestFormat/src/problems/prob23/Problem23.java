package problems.prob23;

import java.util.Random;
import java.util.Scanner;

public class Problem23 {


    public static void main(String[] args) {
        while (true) {
        System.out.println("숫자를 넣어주세요");
        Scanner scan = new Scanner(System.in);

        int Num = scan.nextInt();

            if (Num % 2 == 0) {
                Num = 1;
            } else{
                Num = 2;
            }


            switch (Num) {
                case 1:
                    System.out.println("짝수 입니다.");
                    break;
                case 2:
                    System.out.println("홀수 입니다.");
                    break;
                default :
                    System.out.println("숫자가 아닙니다.");
                    break;
            }

        }
    }
}
