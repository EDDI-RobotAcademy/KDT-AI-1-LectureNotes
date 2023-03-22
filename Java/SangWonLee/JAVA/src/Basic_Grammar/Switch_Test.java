package Basic_Grammar;

import java.util.Scanner;

public class Switch_Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

//        switch (inputNumber){
//            case 1:
//                System.out.println("입금");
//                break;
//            case 2:
//                System.out.println("출금");
//                break;
//            case 3:
//                System.out.println("조회");
//                break;
//            default:
//                System.out.println("뭘 눌렀냐?");
//                break;
//        }

        boolean isLoop = true;

        while (isLoop) {
            System.out.println("숫자를 입력하세요 : "); // 숫자를 입력하게되면
            int inputNumber = scan.nextInt();

            switch (inputNumber){
                case 0:
                    // 숫자 0이 들어오는 경우 isLoop를 false로 바꿈
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
                default:
                    System.out.println("뭘 눌렀냐?");
                    break;
            } // 각각의 케이스 별로 출력된다. 0 누르면 while문에 있는
            // isLoop가 False가 되므로 종료
        }
    }
}
