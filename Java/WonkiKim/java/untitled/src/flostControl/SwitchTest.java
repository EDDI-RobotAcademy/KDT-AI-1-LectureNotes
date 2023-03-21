package flostControl;

import java.util.Scanner;

public class SwitchTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // boolean: 참/거짓을 표현하는 자료형입니다.
        boolean isLoop = true;

        // isLoop가 true인 동안 반복
        while (isLoop) {
            System.out.println("숫자를 입력하세요");
            // 키보드 입력으로 int 타입을 수신한다면 nextInt()를 사용합니다.
            // 만약 double 타입을 원한다면 nextDouble()
            // float 타임을 원하면 nextFloat() 형태로 사용하면 됩니다.
            int inputNumber = scan.nextInt();

            //switch 문을 작성하는 방법
            // 1. switch를 적고 소괄호()를 작성하고 중괄호{}를 작성합니다.
            // 2. 소괄호 내부에 switch case에서 사용할 조건을 적습니다.
            //      -> 현재 케이스에서 inputNumber는 숫자이므로
            //      case 0: 의 의미는 '입력된 숫자가 0이면' 이라는 뜻을 가집니다.
            //      case 1: 은 '입력된 숫자가 1이면' 이란 뜻입니다.
            // 3. 중괄호 내부에는 case 조건들을 적고
            //       각 조건에 대응하는 코드를 작성하면 됩니다.

            switch (inputNumber) {
                case 0:
                    // 숫자 0이 들어오는 경우 isLoop를 false(거짓)으로 바꿈
                    System.out.println("종료");
                    isLoop = false;
                    break;
                case 1:
                    System.out.println("입금!");
                    break;
                case 2:
                    System.out.println("출금!");
                    break;
                case 3:
                    System.out.println("조회");
                    break;
                default:
                    System.out.println("그런 명령은 존재하지 않습니다!");
                    break;

                    // 0~3사이의 숫자가 아닌경우 default를 사용.
            }
        }


    }
}
