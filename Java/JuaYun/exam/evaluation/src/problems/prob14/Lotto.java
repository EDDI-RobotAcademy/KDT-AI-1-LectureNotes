package problems.prob14;

import problems.CustomRandom;

import java.util.Scanner;

// 3 ~ 33까지 숫자 중 당첨번호를 랜덤으로 뽑습니다.
// 사용자 키보드 입력을 받아 번호를 선택하고 선택한 번호가 당첨 번호가 맞다면 승리
// 맞지 않다면 총 7번의 기회
// 7번의 기회를 모두 소진하면 자동으로 패배
public class Lotto {

    Scanner scanner = new Scanner(System.in);
    private int lottoNumber;
    int number = 0;

    // 내가 만든 코드에서 추가적으로 생성해줌
    int firstChance = 0;
    int LastChance = 7;

    public Lotto() {
        lottoNumber = CustomRandom.generateNumber(3,33);

        while (firstChance < LastChance) {
            System.out.println("점수를 입력하세요: ");
            number = scanner.nextInt();
            firstChance++;

            if (lottoNumber == number) {
                System.out.println("승리!");
                return;
            } else {
                System.out.println("패배!");
            }

        }
        System.out.println("기회소진 패배!");
        System.out.println("당첨번호는: " + lottoNumber);

//        for (int i =1; i <= 7; i++) {
//            System.out.println("점수를 입력하세요: " + i +"번째기회");
//            number = scanner.nextInt();
//
//            if (lottoNumber == number) {
//                System.out.println("승리!");
//            } else {
//                System.out.println("패배!");
//            }
//        }


// 내가 만든 코드 7번의 횟수는 생성을 못함
//        System.out.println("점수를 입력하세요: ");
//        number = scanner.nextInt();
//
//        if (lottoNumber == number) {
//            System.out.println("승리!");
//        } else {
//            System.out.println("패배!");
//        }
//        System.out.println(lottoNumber);
    }
}
