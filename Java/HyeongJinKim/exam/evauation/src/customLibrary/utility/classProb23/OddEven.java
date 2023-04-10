package customLibrary.utility.classProb23;

import java.util.Scanner;

public class OddEven {
    final private Scanner scan = new Scanner(System.in);
    private int number;

    public OddEven() {
        System.out.println("숫자를 입력해주세요");
        this.number = scan.nextInt();
        if (number % 2 == 0) {
            System.out.println("짝수입니다.");
        } else {
            System.out.println("홀수입니다.");
        }
    }
}