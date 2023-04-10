package homework;

import java.util.Scanner;

class Member {
    private String email;
    private String password;
    public Member() {
        this.email = email;
        this.password = password;
    }

    // 이메일, 비밀번호 입력
    public void memberInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("이메일을 입력하세요 > ");
        String email = scanner.nextLine();
        System.out.println("비밀번호를 입력하세요 > ");
        String password = scanner.nextLine();
        scanner.close();
    }
}
public class March23_MemberClass {
    public static void main(String[] args) {
        Member member = new Member();
        member.memberInfo();
    }
}
// 이메일과 비밀번호가 제대로 써졌는지 확인하는 방법을 모르겠습니다..