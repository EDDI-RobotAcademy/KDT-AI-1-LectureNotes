package example;

import java.util.Scanner;

public class Member {
    String address;
    int passWord;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("이메일 주소 입력하세요: ");
        String str = sc.nextLine();

        System.out.println("입력한 이메일: " + str);

        if (str ){

        }
        

        System.out.println("비밀번호를 입력하세요: ");
        int PassWord = sc.nextInt();

        System.out.println("입력한 비밀번호: " + PassWord);
    }

}
