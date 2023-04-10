package problems.prob23;

import java.util.Scanner;

public class Problem23 {
    public static void main(String[] args) {
        System.out.println("숫자를 입력해주세요 > ");
        Scanner scan = new Scanner(System.in);
        int inputNum = scan.nextInt();

        final int SECOND_CONDITION = 2;
        final int ODD = 1;
        final int EVEN = 0;


        if(inputNum % SECOND_CONDITION == EVEN){
            System.out.println("해당 숫자는 짝수입니다.");
        }

        if(inputNum % SECOND_CONDITION == ODD){
            System.out.println("해당 숫자는 홀수입니다.");
        }
    }
}
