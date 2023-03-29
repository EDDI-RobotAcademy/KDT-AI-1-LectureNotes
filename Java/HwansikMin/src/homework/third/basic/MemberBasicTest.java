package homework.third.basic;

class MemberTestObject {
    final private String email;
    final private String password;

    public MemberTestObject(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "MemberTestObject{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

public class MemberBasicTest {
    public static void main(String[] args) {
        MemberTestObject member = new MemberTestObject("test@test.com", "비밀번호");

        System.out.println(member);
    }
}
