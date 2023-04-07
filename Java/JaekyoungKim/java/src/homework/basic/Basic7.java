package homework.basic;

import java.util.Scanner;

public class Basic7 {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        final int MAX=100;
        final int MIN=1;
        int decision=scanner.nextInt();

        for (int i=MIN;i<=MAX;i++){
            if (i%decision==0){
                System.out.println(i);
            }
        }


    }
}
