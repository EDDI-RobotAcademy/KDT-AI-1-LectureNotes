package flowControl;

import java.util.Scanner;

public class SwitchTest {
    public static void main(String[] args) {
        // Scanner는 키보드 입력 처리를 위한 객체
        // 실제 서비스 개발하면서 사용할 일은 없지만 현재 콘솔 상황에서
        // 사용자 입력을 받기 위해 코드를 사용.
        // 사용자 입력이란 키보드 입력을 의미
        // System.in이란 입력 시스템을 의미(입력장치에 해당하는 키보드를 의미)
        Scanner scan = new Scanner(System.in);
        // boolean : 참/거짓을 표현하는 자료형
        boolean isLoop = true;
        // isLoop가 true인 동안 반복
        while (isLoop) {
            System.out.print("숫자를 입력하세요: ");
            // 키보드 입력으로 int 타입을 수신한다면 nextInt()
            // double 타입을 원한다면 nextDouble()
            // float   타입을 원한다면 nextFloat()
            int inputNumber = scan.nextInt();
//          switch문 작성 방법
//          1. switch 적고 () 작성하고 {} 작성
//          2. ()안에 switch case에서 사용할 조건을 작성
//             -> 현재 케이스에서 inputNumber는 숫자이므로
//                case 0은 '입력된 숫자가 0이면' 이라는 뜻
//                case 1은 '입력된 숫자가 1이면' 이라는 뜻
//          3. {}안에 case에 조건을 작성하고 각 조건의 대응하는 코드를 작성
            switch (inputNumber) {
                case 0:
                    // 0이 들어오는 경우 isLoop를 false로 바꿈
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
                // default = 설정한 case가 아닌 경우 출력
                default:
                    System.out.println("그런 명령은 존재 X");
                    break;
            }
        }
    }
}
