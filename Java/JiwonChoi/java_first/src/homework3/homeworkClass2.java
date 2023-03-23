package homework3;
import java.util.Scanner;
class Member {
    String email;
    String password;

    public Member() {
    }

    //회원정보 입력용
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    //회원정보 확인 함수
    public static void checkInfo(Member member) {
        System.out.println("이메일 :" + member.getEmail());
        System.out.println("비밀번호 :" + member.getPassword());
    }
}
public class homeworkClass2 {
    public static void main(String[] args) {
        //회원가입
        Scanner scan1 = new Scanner(System.in);
        System.out.println("이메일을 입력하세요 : ");
        String email = scan1.next();

        Scanner scan2 = new Scanner(System.in);
        System.out.println("비밀번호를 입력하세요 : ");
        String password = scan2.next();

        Member member = new Member();
        member.setEmail(email);
        member.setPassword(password);

        //회원정보확인
        Member.checkInfo(member);
    }
}


/*
입력창과 확인은 출력되지만
정보 저장은 안된거 같습니다.
그럼 회원가입이라고 할 수 없는거지요?
저장은 어떻게 해야할까요?
*/
