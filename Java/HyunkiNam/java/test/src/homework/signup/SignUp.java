package homework.signup;

import java.util.Scanner;

class Member{

    final String mail;
    final String password;

    Scanner sc = new Scanner(System.in);

    public Member(){
        this.mail = inputMail();
        this.password = inputPassword();
    }

    public String inputMail(){
        System.out.println("이메일 입력");
        String mail = sc.next();
        return mail;
    }

    public String inputPassword(){
        System.out.println("패스워드 입력");
        String password = sc.next();
        return password;
    }

    @Override
    public String toString() {
        return "mail = '" + mail + '\'' +
                ", password='" + password + '\'';
    }
}
public class SignUp {
    public static void main(String[] args) {
        Member member = new Member();
        System.out.println(member);
    }
}
