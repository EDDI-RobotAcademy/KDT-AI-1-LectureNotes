package problems.prob14;

import java.util.Scanner;
import customLibrary.CustomRandom;

public class Problem14 {
    public static void main (String[] args) {
        final int NUMBER_MIN = 3;
        final int NUMBER_MAX = 33;
        final int lotto = CustomRandom.generateNumber(NUMBER_MIN, NUMBER_MAX);
        int chance = 7;
        int select = 0;

        Scanner scanner = new Scanner(System.in);

        do {
            // 범위 밖의 숫자에 대한 처리는 시간이 모자랐음
            System.out.print("숫자 입력 : ");
            select = scanner.nextInt();

            if (lotto == select) {
                System.out.println("당첨 번호 : " + lotto);
                System.out.println("승리!");
                break;
            } else {
                System.out.print("실패");
                chance--;
                System.out.println(", 남은 기회 : " + chance + "번");
            }
        } while (chance != 0);
        System.out.println("당첨 번호 : " + lotto);
    }
}
