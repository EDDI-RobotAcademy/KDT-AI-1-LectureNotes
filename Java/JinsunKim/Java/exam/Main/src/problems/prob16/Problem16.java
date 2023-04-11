package problems.prob16;


//키보드 입력을 받아서 짝수인지 홀수인지 판정하는 프로그램을 만들어 봅시다.

import java.util.Scanner;

public class Problem16 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);


        boolean number = true;
        while (number) {

            System.out.print("숫자를 입력하세요");
            int scanner = scan.nextInt();

            if (scanner % 2 == 0) {
                System.out.println("숫자 " + scanner + "는 짝수 입니다. ");
            }
            else if (scanner % 2 != 0) {
                System.out.println("숫자 " + scanner + "는 홀수 입니다. ");
            }
            else
                System.out.println("다시 입력해주세요 ");

        }
    }
}
