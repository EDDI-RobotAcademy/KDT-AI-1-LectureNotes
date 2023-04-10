package homework.productHomework2.member;

public class Member {

    // 멤머 아이디, 이메일,  패스워드 표기
    final private int memberId;
    final private String email;
    final private String password;

    // 멤버 아이디(interger), 이메일, 비밀번호 받아서 초기화
    public Member(int memberId, String email, String password) {
        this.memberId = memberId;
        this.email = email;
        this.password = password;

    }

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