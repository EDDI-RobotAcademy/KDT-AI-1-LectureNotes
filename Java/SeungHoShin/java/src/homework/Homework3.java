package homework;
import java.util.Scanner;
class Member{
    String Email;
    String Password;

    Member(String Email, String Password){
        this.Email = Email;
        this.Password=Password;
    }
    void login(){
        System.out.printf("확인하겠습니다.\n이메일은 %s \n비밀번호는 %s 맞나요? ", Email, Password);
    }
}
public class Homework3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("이메일과 비밀번호 를 입력해주세요>>");
        String Email = sc.nextLine();
        String Password = sc.nextLine();
        sc.close();

        Member s = new Member(Email, Password);
        s.login();
    }

    }





