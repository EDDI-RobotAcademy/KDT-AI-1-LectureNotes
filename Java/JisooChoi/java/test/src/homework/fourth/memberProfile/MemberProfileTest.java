package homework.fourth.memberProfile;

import java.util.Scanner;

public class MemberProfileTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("닉네임, 도시, 거리명, 세부주소, 우편번호를 기입해주세요. > (enter)");
        String nickName = scan.nextLine();
        String city = scan.nextLine();
        String streetName = scan.nextLine();
        String detailAdd = scan.nextLine();
        String postalAdd = scan.nextLine();

        // 방법 1
        Address address = new Address(city, streetName, detailAdd, postalAdd);
        MemberProfile member = new MemberProfile(nickName, address);
        member.showInfo();

        // 방법 2
        MemberProfile member2 = new MemberProfile(nickName, city, streetName, detailAdd, postalAdd);
        member2.showInfo();
    }
}
