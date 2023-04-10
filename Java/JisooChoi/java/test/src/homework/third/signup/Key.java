package homework.third.signup;

import java.util.Scanner;

public class Key{
    int key;

    public Key(){
    }

    public void getKey(){
        System.out.print("비밀번호: ");
        Scanner scanNum = new Scanner(System.in);

        this.key = scanNum.nextInt();
    }
}
