package _homework_03_02;

import java.util.Scanner;

class MemberInfo {
    Scanner scan = new Scanner(System.in);

    public MemberInfo() {
        System.out.print("가입할 이메일을 입력해주세요.");
        final String UserEmail = scan.nextLine();
        System.out.print("가입할 비밀번호를 입력해주세요.");
        final String UserPassword = scan.nextLine();
        System.out.println("입력하신 이메일 주소는 " + UserEmail + " 이며 비밀번호는 " + UserPassword + "입니다.");
    }
}


public class Member {
    public static void main(String[] args) {

        MemberInfo member = new MemberInfo();
        System.out.println(member);

    }
}