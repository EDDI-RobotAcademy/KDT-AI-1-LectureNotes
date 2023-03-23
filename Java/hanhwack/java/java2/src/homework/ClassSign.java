package homework;

import java.util.Scanner;

class Member {
    private String name;
    private String address;

    public Member() {

    }

    public String getName() {
        System.out.println("당신의 이름은 " + name);
        return name;
    }

    public void setName(Scanner scan) {
        System.out.println("당신의 이름을 입력하시오");
        this.name = scan.next();
    }

    public String getAddress() {
        System.out.println("당신의 이메일 주소는 " + address);
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

        member.setName(scan);
        member.setAddress(scan);
        member.getName();
        member.getAddress();


    }
}
