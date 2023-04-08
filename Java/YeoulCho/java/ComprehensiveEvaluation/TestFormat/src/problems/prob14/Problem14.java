package problems.prob14;

import customLibrary.utility.random.CustomRandom;

import java.util.Scanner;

public class Problem14 {
    public static void main(String[] args) {
        final int winNumber =CustomRandom.generateNumber(3,33);
        for(int i=0; i<7 ; i++) {
            System.out.println("3~33번호를 입력해주세요");
            Scanner scan = new Scanner(System.in);
            int num = scan.nextInt();
            if (num == winNumber) {
                System.out.println("정답");
                break;
            }
            System.out.println("땡");
        }
        System.out.println("당첨번호: " + winNumber);
    }
}
