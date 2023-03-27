package homework;

import java.util.Scanner;

class MemberProfile {
    final private String city;
    final private String street;
    final private String details;
    final private String zipcode;

    public MemberProfile(String city, String street,
                         String details, String zipcode){
        this.city = city;
        this.street = street;
        this.details = details;
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return "MemberProfile{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", details='" + details + '\'' +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }
}
class TestTestMemberRequest2 {
    final private String memberId;
    final private String password;
    final private Scanner sc = new Scanner(System.in);

    final private String city;
    final private String street;
    final private String details;
    final private String zipcode;
    public TestTestMemberRequest2(){
        System.out.println("아이디를 입력해주세요: ");
        this.memberId = sc.nextLine();
        System.out.println("비밀번호를 입력해주세요: ");
        this.password = sc.nextLine();

        System.out.println("서울 거리 세부주소 1234");
        this.city = "서울";
        this.street = "거리";
        this.details = "세부주소";
        this.zipcode = "1234";
    }
    public TestTestMember2 toTestTestMember() {
        return new TestTestMember2(memberId, password,
                new MemberProfile(city, street, details, zipcode));

    }
}
class TestTestMember2 {
    final private String memberId;
    final private String password;
    final private MemberProfile memberProfile;

    public TestTestMember2(
            String memberId, String password, MemberProfile memberProfile) {
        this.memberId = memberId;
        this.password = password;
        this.memberProfile = memberProfile;
    }
    @Override
    public String toString() {
        return "TestTestMember2{" +
                "memberId='" + memberId + '\'' +
                ", password='" + password + '\'' +
                ", memberProfile=" + memberProfile +
                '}';
    }
}
public class MemberDomainExtensionWithoutSetter {
    public static void main(String[] args) {
        System.out.println("외부에서 요청이 들어옵니다!");
        TestTestMemberRequest2 memberRequest = new TestTestMemberRequest2();
        TestTestMember2 member = memberRequest.toTestTestMember();
        System.out.println(member);
    }
}
