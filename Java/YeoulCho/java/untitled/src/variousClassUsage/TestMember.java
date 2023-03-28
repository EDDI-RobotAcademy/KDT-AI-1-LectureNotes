package variousClassUsage;

public class TestMember {
    final private int memberId;
    final private String email;
    final private String password;


    public TestMember(int memberId, String email, String password) {
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
