package problems.prob23;

import java.util.Scanner;

public class Problem23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int EVEN_CHECK = 2;

        if(number % EVEN_CHECK == 0){
            System.out.println("짝수");
        }else {
            System.out.println("홀수");
        }
    }
}
