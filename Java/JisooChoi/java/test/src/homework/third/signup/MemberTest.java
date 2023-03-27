package homework.third.signup;

public class MemberTest {
    final private Email email;
    final private Key key;

    public MemberTest(){
        this.email = new Email();
        this.key = new Key();
    }

    public void getMemberEmail(){
        email.getEmail();
    }

    public void getMemberKey(){
        key.getKey();
    }

    public void showEmailKey(){
        System.out.println("입력하신 이메일: " +email.email+ ", 입력하신 비밀번호: " +key.key);
    }
}

