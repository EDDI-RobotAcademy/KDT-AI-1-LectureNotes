package problems.prob14;

import customLibrary.CustomRandom;

import java.util.Scanner;

// 3 ~ 33까지 당첨 번호 랜덤 생성 - 커스텀랜덤
// 키보드 입력 -> 번호 선택
// 번호 맞으면 승리
// 맞지 않으면 7번의 기회
// 7번 이후 자동 패배처리
public class FindWinNumber {

    public void selectNumber() {
            int winNumber = CustomRandom.generateNumber(3, 33);
            Scanner scanner = new Scanner(System.in);

            System.out.println("번호를 입력하세요 > ");
            int writeNumber = scanner.nextInt();

            if (writeNumber == winNumber) {
                System.out.println("승리!");
        }
            else {
                System.out.println("지금부터 7번의 기회가 더 주어집니다");

                int secondNumber;
                for (int i = 0; i < 7; i++) {
                    System.out.println((i+1) + "번 더 기회 > ");
                    secondNumber = scanner.nextInt();

                    if (secondNumber == winNumber) {
                        System.out.println("승리!");
                        break;
                    } else {
                        System.out.println("실패");
                    }
                }
            }
    }
}
