package problems.prob23;

// 문제 23번

import java.util.Scanner;

class CheckEvenOrOdd{
    final private int num;
    final private int checkNum = 2;

    public CheckEvenOrOdd() {
        Scanner scan = new Scanner(System.in);
        num = scan.nextInt();
    }
    public void printResultEvenOrOdd(){
        if(num % checkNum == 0){
            System.out.println("짝수입니다.");
        }
        if(num % checkNum == 1){
            System.out.println("홀수입니다.");
        }
    }

}
public class Problem23 {
    public static void main(String[] args) {
        System.out.println("값을 입력해주세요.");
        CheckEvenOrOdd checkEvenOrOdd = new CheckEvenOrOdd();
        checkEvenOrOdd.printResultEvenOrOdd();
    }
}
