package homework.Third;

class MemberTestObject{
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

public class ClassBasic2A1 {
    public static void main(String[] args) {
        MemberTestObject member = new MemberTestObject("abc@naver.com","Asdsaf");
        System.out.println(member);

    }
}
