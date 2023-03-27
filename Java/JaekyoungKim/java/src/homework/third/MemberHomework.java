package homework.third;
import java.util.Scanner;
class Member {
    String email;
    String password;
    public Member(){
        Scanner scanner = new Scanner(System.in);
        this.email = scanner.nextLine();
        this.password= scanner.nextLine();
    }
    @Override
    public String toString(){
        return "당신이 입력한 이메일은  "+email+" 입니다.\n 당신이 입력한 비밀번호는 "+password+" 입니다.";
    }
}
public class MemberHomework {
    public static void main(String[] args) {

        Member member = new Member();
        System.out.println(member);
    }
}
