package problems.prob14;

import customLibrary.CustomRandom;

import java.util.Scanner;

public class Problem14 {
    public static void main(String[] args) {
        // 3 ~ 33까지 숫자 중 당첨 번호를 랜덤으로 뽑습니다.
        //사용자 키보드 입력을 받아 번호를 선택하고 선택한 번호가 당첨 번호가 맞다면 승리합니다.
        //만약 맞지 않다면 총 7번의 기회가 주어집니다.
        //7번의 기회를 모두 소진하면 자동 패배 처리 됩니다.
        Scanner sc = new Scanner(System.in);
        int MIN = 3;
        int MAX = 33;
        int Chance = 7;
        int num;

        while (true) {
            System.out.print("뽑기시작 ->");
            num = sc.nextInt();
            int RandomNum = CustomRandom.generateNumber(MIN, MAX);
            if (RandomNum == num) {
                System.out.println(RandomNum);
                System.out.println("당첨!");
                return;

            }
                else if (RandomNum != num) {
                    System.out.println(RandomNum);
                    System.out.println("실패...");
            }
        }
    }
}
