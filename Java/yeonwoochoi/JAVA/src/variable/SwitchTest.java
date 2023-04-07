package variable;

import java.util.Scanner;

public class SwitchTest {
    public static void main(String[] args) {

        // Scanner는 키보드 입력 처리를 위해 사용하는 객체입니다.
        // 여러분이 실제 서비스를 개발하면서 아래 코드를 사용할 일은 없지만
        // 현재 콘솔 상황에서 사용자 입력을 받기 위해 아래 코드가 사용된다 보면 되겠습니다.
        // 사용자 입력이란 구체적으로 키보드 입력을 의미합니다.
        // System.in 이란 입력 시스템을 의미하므로
        // 입력 장치에 해당하는 키보드를 의미한다 봐도 무방하겠습니다.

        // 결론: 사람의 키보드 입력을 받고 싶으면 아래 코드 한 줄을 입력하세요.
        Scanner scan = new Scanner(System.in);

        // boolean : 참/거짓을 표현하는 자료형입니다.
        boolean isLoop = true;

        // isLoop가 true인 동안 반복
        while (isLoop){
            System.out.println("숫자를 입력하세요: ");
            // 키보드 입력으로 int 타입을 수신한다면 nextInt()를 사용합니다.
            // 만약 double 타입을 원한다면 nextdouble()
            // float 타입을 원하면 nextFloat() 형태로 사용하면 됩니다.
            int inputNumber = scan.nextInt();

            // switch 문을 작성하는 방법
            // 1. switch를 적고 소괄호() 를 작성하고 중괄호{}를 작성합니다.
            // 2. 소괄호 내부에 switch case 에서 사용할 조건을 적습니다.
            //    -> 현재 케이스에서 inputNumber 는 숫자이므로
            //       case 0: 의 의미는 '입력된 숫자가 0이면' 이라는 뜻을 가집니다.
            //       case 1: 은 '입력된 숫자가 1이면' 이란 뜻입니다.
            // 3. 중괄호 내부에는 case 조건들을 적고
            //    각 조건에 대응하는 코드를 작성하면 됩니다.
            switch (inputNumber){
                case 0:
                    // 숫자 0이 들어오는 경우 isLoop를 false(거짓)으로 바꿈
                    System.out.println("종료");
                    isLoop = false;
                    break;

                case 1:
                    System.out.println("입금");
                    break;

                case 2:
                    System.out.println("출금");
                    break;

                case 3:
                    System.out.println("조회");
                    break;

                // default : 0 ~ 3 사이의 숫자가 아닌 경우
                default:
                    System.out.println("그런 명령은 존재하지 않습니다!");
                    break;

            }

        }

    }
}
