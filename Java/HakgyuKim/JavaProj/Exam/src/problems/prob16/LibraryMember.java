package problems.prob16;

import java.util.Scanner;

public class LibraryMember {
    Scanner scanner = new Scanner(System.in);
    final private String email;
    final private String password;

    public LibraryMember() {
        System.out.println("이메일을 입력하세요");
        this.email = scanner.next();
        System.out.println("비밀번호를 설정하세요");
        this.password = scanner.next();;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "LibraryMember{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
