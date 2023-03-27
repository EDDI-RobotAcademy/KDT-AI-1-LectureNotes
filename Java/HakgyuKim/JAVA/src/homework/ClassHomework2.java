package homework;

import java.util.Scanner;

class Member {
    private String Email;
    private String Password;

    public Member(String email, String password) {
        Email = email;
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}

public class ClassHomework2 {
    public static void main(String[] args) {

        System.out.println("이메일을 입력해주세요: ");
        Scanner emailScan = new Scanner(System.in);
        String userEmail = emailScan.next();

        System.out.println("비밀번호를 입력해주세요: ");
        Scanner passwordScan = new Scanner(System.in);
        String userPassword = passwordScan.next();

        Member member = new Member(userEmail,userPassword);

        System.out.println("이메일 주소는: " + member.getEmail());
        System.out.println("비밀번호는: " + member.getPassword());



    }
}
