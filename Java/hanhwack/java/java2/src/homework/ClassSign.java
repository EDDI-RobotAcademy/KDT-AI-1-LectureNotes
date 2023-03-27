package homework;

import java.util.Scanner;

class Member {
    private String password;
    private String address;

    public Member() {

    }

    public String getPassword() {
        System.out.println("당신의 비밀번호는 " + password + "입니다.");
        return password;
    }

    public void setPassword(Scanner scan) {
        System.out.println("당신의 비밀번호를 입력하시오");
        this.password = scan.next();
    }

    public String getAddress() {
        System.out.println("당신의 이메일 주소는 " + address +"입니다. ");
        return address;
    }

    public void setAddress(Scanner scan) {
        System.out.println("당신의 이메일 주소를 입력하시오");
        this.address = scan.next();
    }
}

public class ClassSign {

    public static void main(String[] args) {


        final Member member = new Member();
        Scanner scan = new Scanner(System.in);

        member.setAddress(scan);
        member.setPassword(scan);

        member.getAddress();
        member.getPassword();

    }
}
