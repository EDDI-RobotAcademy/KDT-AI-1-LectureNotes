package homework.third;

import java.util.Scanner;

class Member{
    final private Email email;
    final private Key key;

    public Member(){
        this.email = new Email();
        this.key = new Key();
    }

    public void getMemberEmail(){
        email.getEmail();
    }

    public void getMemberKey(){
        key.getKey();
    }

    public void showEmailKey(){
        System.out.println("입력하신 이메일: " +email.email+ ", 입력하신 비밀번호: " +key.key);
    }
}

class Email{
    String email = "";

    public Email(){
    }

    public void getEmail() {
        System.out.print("이메일: ");
        Scanner scanEmail = new Scanner(System.in);

        this.email = scanEmail.nextLine();
    }
}

class Key{
    int key;

    public Key(){
    }

    public void getKey(){
        System.out.print("비밀번호: ");
        Scanner scanNum = new Scanner(System.in);

        this.key = scanNum.nextInt();
    }
}

public class SignUpClass {
    public static void main(String[] args) {
        Member member = new Member();
        member.getMemberEmail();
        member.getMemberKey();
        member.showEmailKey();
    }
}