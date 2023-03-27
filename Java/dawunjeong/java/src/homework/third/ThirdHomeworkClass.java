package homework.third;

import java.util.Scanner;

class Member {
    final String email;
    final String pw;
    Scanner scan = new Scanner(System.in);

    public Member() {
        System.out.println("이메일을 입력하세요");
        email = scan.next();
        System.out.println("비밀번호를 입력하세요");
        pw = scan.next();
    }
}
public class ThirdHomeworkClass {
    public static void main(String[] args) {
        Member member = new Member();
        System.out.println();
        System.out.println("입력한 내용이 맞는지 확인하세요.");
        System.out.println("이메일 : " + member.email);
        System.out.println("비밀번호 : " + member.pw);
    }
}