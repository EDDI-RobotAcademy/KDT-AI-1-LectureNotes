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
            System.out.println("숫자를 입력하세요 : ");
            int inputNumber = scan.nextInt();

            switch (inputNumber){
                case 0:
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
            }
        }
    }
}
