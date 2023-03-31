package variousClassUsage.refactor;


public class RefactorMember {
    final private int memberId;
    // 이 값을 static으로 할수는 없다.
    final private String email;
    final private String password;

    public RefactorMember(int memberId, String email, String password) {
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
