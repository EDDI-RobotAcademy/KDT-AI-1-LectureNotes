package problems.prob14;

import problems.CustomRandom;
import java.util.Scanner;

public class Problem14 {
    public static void main(String[] args) {
        // 미완성 15번은 완료

        int MAX = 33;
        int MIN = 3;
        int Input_Number = 0;
        int Repeat_Count = 7;
        boolean run = true;
        Scanner scanner = new Scanner(System.in);

        while(run) {
            int Lotto = CustomRandom.generateNumber(MIN,MAX);
            Input_Number = scanner.nextInt();

            if (Lotto == Input_Number) {
                System.out.println("정답");
                break;
            }
            if (Input_Number > Lotto) {
                System.out.println("틀렸습니다.");
            } else {
                System.out.println("틀렸습니다.");
            }
            Repeat_Count++;
        }

    }
}
