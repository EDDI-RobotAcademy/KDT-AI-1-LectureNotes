package homework.third.review;

import java.util.Scanner;

class TestTestMemberRequest {
    final private String memberId;
    final private String password;
    final private Scanner scan = new Scanner(System.in);

    public TestTestMemberRequest() {
        System.out.print("아이디를 입력하세요: ");
        this.memberId = scan.nextLine();
        System.out.print("비밀번호를 입력하세요: ");
        this.password = scan.nextLine();
    }

    public TestTestMember toTestTestMember () {
        return new TestTestMember(memberId, password);
    }
}

class TestTestMember {
    final private String memberId;
    final private String password;

    public TestTestMember(String memberId, String password) {
        this.memberId = memberId;
        this.password = password;
    }

    @Override
    public String toString() {
        return "TestTestMember{" +
                "memberId='" + memberId + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

public class HowToScanWithoutSetter {
    public static void main(String[] args) {
        System.out.println("외부에서 요청이 들어옵니다!");
        // 입력된 요청
        TestTestMemberRequest memberRequest = new TestTestMemberRequest();
        // 요청을 기반으로 setter 없이 처리
        TestTestMember member = memberRequest.toTestTestMember();
        // 출력
        System.out.println(member);
        // 이렇게 만들면 setter 없이 객체를 만들 수 있습니다.
    }
}
