package answer;

class MemberTestObject { //shift + f6 누르면 관련된 애들 다같이 바꿀 수 있음)
    final private String emali;
    final private String password;
    public MemberTestObject(String emali, String password) {
        this.emali = emali;
        this.password = password;
    }

    @Override
    public String toString() {
        return "MemberTestObject{" +
                "emali='" + emali + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

public class March23_MemberClass_Ans {
    public static void main(String[] args) {
        MemberTestObject member = new MemberTestObject("test@test.com", "비밀번호");
        System.out.println(member);
    }
}
