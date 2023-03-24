package example;

public class Member {
    private String email;
    private String password;

    public Member (String s, String 비밀번호) {
        this.email = email;
        this.password = password;

    }

    @Override
    public String toString() {
        return "Member{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Member member = new Member("jinho159@naver.com", "비밀번호");
        System.out.println(member);
    }
}

