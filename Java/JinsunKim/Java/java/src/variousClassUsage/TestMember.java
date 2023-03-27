package variousClassUsage;

//사용자관리, 누가 이상품을 구매했는지 관리

public class TestMember {
    final private int memberId;
    // 이것을 도입하게 된 계기는..
    // 이메일보다는 숫자형태로 검색하는게 빠르기 때문에 int 형 정보를 생성한다.
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
