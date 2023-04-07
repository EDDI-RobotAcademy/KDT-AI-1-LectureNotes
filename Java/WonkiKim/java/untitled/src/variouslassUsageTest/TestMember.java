package variouslassUsageTest;

public class TestMember {
    final private String email;
    final private String password;
    final private int memberId;

    public TestMember(String email, String password, int memberId) {
        this.email = email;
        this.password = password;
        this.memberId = memberId;

    }
    public int getMemberId() {
        return memberId;
    }

    @Override
    public String toString() {
        return "TestMember{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", mamberId='" + memberId +
                '}';
    }
}
