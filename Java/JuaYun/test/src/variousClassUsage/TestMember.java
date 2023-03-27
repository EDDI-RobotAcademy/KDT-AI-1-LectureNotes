package variousClassUsage;

public class TestMember {

    // 찾기 쉽게 정수형태로 된 memberId를 만들고
    // 회원의 이메일과 비밀번호를 생성
    final private int memberId;
    final private String email;
    final private String password;

    // 생성자
    public TestMember(int memberId, String email, String password) {
        this.memberId = memberId;
        this.email = email;
        this.password = password;
    }

    // MemberId를 얻기 위해 리턴값설정
    public int getMemberId() {
        return memberId;
    }

    @Override
    public String toString() {
        return "TestMember{" +
                "memberId=" + memberId +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
