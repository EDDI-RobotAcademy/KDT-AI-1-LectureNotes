package problems.prob23;

import java.util.Scanner;

public class Problem23 {
    public static void main(String[] args) {
        final int DICISION = 2;
        final int EVEN = 0;
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if(input%DICISION == EVEN){
            System.out.println("EVEN");
        } else System.out.println("ODD");
    }
}
