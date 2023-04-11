package problems.prob16;

import java.util.Scanner;

public class Join {
    Scanner scanner = new Scanner(System.in);

    public void joinMember() {
        System.out.println("회원가입을 시작합니다.");

        System.out.println("이름을 적어주세요 > ");
        String name = scanner.next();
        System.out.println("아이디를 적어주세요 > ");
        String id = scanner.next();
        System.out.println("비밀 번호를 적어주세요 > ");
        String password = scanner.next();

        System.out.println("반갑습니다 " + name + "님");
        System.out.println("Id: " + id);
        System.out.println("비밀번호: ***");
        System.out.println("회원가입이 완료되었습니다!");

    }
}
