package HomeWork;

import java.util.Scanner;


class Member_info {
    public String member_email() {
        Scanner s = new Scanner(System.in);
        System.out.print("이메일을 입력하세요 : ");

        return s.nextLine();
    }

    public String member_pw() {
        Scanner s = new Scanner(System.in);
        System.out.print("비밀번호를 입력하세요 : ");

        return s.nextLine();
    }
}
class Member_all_info {
    public void member_all(){
        Member_info mem = new Member_info();

        System.out.println("이메일은  " + mem.member_email() + "  이고," +
                " 비밀번호는  " + mem.member_pw() + "  입니다.");

    }

}

public class Member {
    public static void main(String[] args) {

        Member_all_info allmem = new Member_all_info();
        allmem.member_all();

    }
}
