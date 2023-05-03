package question;

import java.util.Scanner;

class MemberProfile{
    Scanner sc = new Scanner(System.in);

    private String Name;
    private String City;
    private String Street;
    private String DetailedAddress;
    private String ZipCord;

    public MemberProfile() {
        System.out.print("닉네임: ");
        Name = sc.next();
        System.out.print("도시: ");
        City = sc.next();
        System.out.print("거리명: ");
        Street = sc.next();
        System.out.print("세부주소: ");
        DetailedAddress = sc.next();
        System.out.print("우편번호: ");
        ZipCord = sc.next();
        System.out.print('\n');
    }

    @Override
    public String toString() {
        return "닉네임: " + Name + '\n' +
                "도시: " + City + '\n' +
                "거리명: " + Street + '\n' +
                "세부주소: " + DetailedAddress + '\n' +
                "우편번호: " + ZipCord;
    }
}
public class Question_5 {
    public static void main(String[] args) {
        MemberProfile member = new MemberProfile();
        System.out.println(member);

    }
}
