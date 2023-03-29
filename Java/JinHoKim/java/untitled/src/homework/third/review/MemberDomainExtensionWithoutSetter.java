package homework.third.review;

import java.util.Scanner;

class MemberProfile {
    final private String city;
    final private String street;
    final private String details;
    final private String zipcode;

    public MemberProfile(String city, String street, String details, String zipcode) {
        this.city = city;
        this.street = street;
        this.details = details;
        this.zipcode = zipcode;
    }

    @Override
    public String
    toString() {
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
    final private Scanner scan = new Scanner(System.in);

    final private String city;
    final private String street;
    final private String details;
    final private String zipcode;

    public TestTestMemberRequest2() {
        System.out.print("아이디를 입력하세요: ");
        this.memberId = scan.nextLine();
        System.out.print("비밀번호를 입력하세요: ");
        this.password = scan.nextLine();

        System.out.println("귀찮으니 거주지 입력했다 가정");
        this.city = "서울";
        this.street = "거리";
        this.details = "세부 주소";
        this.zipcode = "12345";
    }

    // Domain 객체 확장 이전
//    public TestTestMember2 toTestTestMember () {
//        return new TestTestMember2(memberId, password);
//    }

    // Domain 객체 확장 이후(MemberProfile 추가)
    public TestTestMember2 toTestTestMember () {
        return new TestTestMember2 (
                memberId, password,
                new MemberProfile(city, street, details, zipcode));
    }
}

class TestTestMember2 {
    final private String memberId;
    final private String password;
    final private MemberProfile memberProfile;

//    public TestTestMember2(String memberId, String password) {
//        this.memberId = memberId;
//        this.password = password;
//    }

    public TestTestMember2(
            String memberId, String password,
            MemberProfile memberProfile) {

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
        // 입력된 요청
        TestTestMemberRequest2 memberRequest = new TestTestMemberRequest2();
        // 요청을 기반으로 setter 없이 처리
        TestTestMember2 member = memberRequest.toTestTestMember();
        // 출력
        System.out.println(member);
    }
}