package homework;
import java.util.Scanner;
class Member {

static Scanner scanner = new Scanner(System.in);

static class EmailAddress {

    private String EmailAddress;


    public EmailAddress() {
        this.EmailAddress = EmailAddress;

        System.out.println("이메일을 입력하세요 : ");
        String EmailAddressInput = scanner.nextLine();

        System.out.println(EmailAddressInput);


    }
}

static class Password {
    private Integer Password;

    public Password() {
        this.Password = Password;

        System.out.println("비밀번호를 입력하세요 : ");
        int PasswordInput = scanner.nextInt();

        System.out.println(PasswordInput);
    }


}
}


public class MemberClassHomework {
    public static void main(String[] args) {
        Member member = new Member();
        new Member.EmailAddress();
        new Member.Password();
    }
}
