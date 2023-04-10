package problems.prob23;

import java.util.Scanner;

public class Problem23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int EVEN = 2;

            System.out.println("숫자를 입력해주세요.");
            int num = sc.nextInt();
            if (num % EVEN == 0){
                System.out.println("짝수입니다.");
            }
            else
            {
                System.out.println("홀수입니다.");
            }
        }

    }
