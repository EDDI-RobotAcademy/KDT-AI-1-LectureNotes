package problems.prob23;
/*
키보드 입력을 받아서 짝수인지 홀수인지 판정하는 프로그램을 만들어 봅시다.
 */

import java.util.Scanner;

class EvenCheck {
    final private int EVEN= 2;
    Scanner scanner = new Scanner(System.in);
    public EvenCheck () {
        System.out.println("수를 입력해주세요: ");
       int checkNumber = scanner.nextInt();
        System.out.println(+ checkNumber);
        if (checkNumber % EVEN == 0) {
            System.out.println("짝수입니다");
        } else {
            System.out.println("홀수입니다");
        }

    }
}

public class Problem23 {
    public static void main(String[] args) {
        System.out.println(new EvenCheck());
    }
}
