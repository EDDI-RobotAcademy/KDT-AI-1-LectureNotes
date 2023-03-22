package homework;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        int n = 5;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            final int dice_Number = (int) (Math.random() * 6) + 1;

            System.out.println("주사위" + (i + 1) + ":" + dice_Number);
            sum += dice_Number;


        }

        System.out.println("주사위" + n + "의 합은" + sum);

        final int WInner_decision_number=4;

        if (sum % WInner_decision_number == 0) {
            System.out.println("승리하셨습니다");
        } else {
            System.out.println("패배하셨습니다!!.");


        }
    }
}









