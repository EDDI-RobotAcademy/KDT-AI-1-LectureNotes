package homework3;

class Member {
    String email;
    int password;

    public Member(String email, int password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Member{" +
                "email='" + email + '\'' +
                ", password=" + password +
                '}';
    }
}

public class MemberTest {
    public static void main(String[] args) {
        Member member1 = new Member("jinho1593@naver.com", 123456);
        System.out.println(member1);
    }
}
