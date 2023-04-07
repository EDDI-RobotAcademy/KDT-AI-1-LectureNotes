package rewiew.vCUsageReview;

public class TMemberReview {
    // 회원정보를 알기 위함
    // 일단 이메일과 비밀번호 생성

    final private String email;
    final private String password;

    public TMemberReview(String email, String password, int memberId) {
        this.email = email;
        this.password = password;
        this.memberId = memberId;
    } // 생성자 만들기 전에 오류 났고 생성자 만들자 오류 안남 -why?
    // 'final' 키워드는 변수가 초기화되면 그 값을 변경할 수 없음을 의미
    // -> 초기화되지 않으면 오류 일으킴
    // 그래서 생성자 값에서 초기화 해주는 것 (쌤한테 다시 물어볼 것)

    final private int memberId;

    public int getMemberId() {
        return memberId;
    }

    @Override
    public String toString() {
        return "TMemberReview{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", memberId=" + memberId +
                '}';
    }
}
