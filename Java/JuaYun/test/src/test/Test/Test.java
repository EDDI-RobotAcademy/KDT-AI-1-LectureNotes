package test.Test;

class Member {
    final private String id;
    final private String pw;

    public Member(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                '}';
    }
}
public class Test {
    public static void main(String[] args) {
        Member member = new Member("asd@asd.com", "비밀번호");

    }
}
