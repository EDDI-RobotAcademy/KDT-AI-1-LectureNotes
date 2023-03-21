package flowControl;

import java.util.Scanner;

public class SwitchTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        boolean isLoop = true;

        while (isLoop) {
            System.out.println("숫자를 입력하세요: ");
            int inputNumber = scan.nextInt();

            switch (inputNumber) {
                case 1:
                    System.out.println("입금!");
                    break;

                case 2:
                    System.out.println("출금!");
                    break;

                case 3:
                    System.out.println("조회!");
                    break;

                default:
                    System.out.println("그런 명령은 존재하지 않습니다!");
                    break;
            }

        }
    }
}