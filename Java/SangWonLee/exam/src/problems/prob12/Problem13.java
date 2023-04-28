package problems.prob12;

import java.util.Scanner;

public class Problem13 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ThreeThree threeThree;
        int inputCount = 0;
        int bigShotNumber = new ThreeThree().getRandomNumber();

        System.out.println(bigShotNumber);

        while (inputCount < 7) {
            inputCount++;
            System.out.println("현재 " + inputCount + " 번째 시도 !!");
            System.out.print("당첨 번호를 맞춰보세요 : ");
            int inputNumber = sc.nextInt();
            if (inputNumber == bigShotNumber) {
                System.out.println(" 당첨 !! ");
                return;
            } else {
                System.out.println(" 꽈아앙 ");
            }
        }
        System.out.println(inputCount + " 시도를 모두 썼어요 ㅜㅜ");

    }


}
