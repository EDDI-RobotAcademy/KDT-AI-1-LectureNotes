package homework.homework3;
import java.util.Scanner;
class MemberInfo {
        String email;
        String password;

        public MemberInfo() {
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public void setPassword(String password) {
            this.password = password;
        }


    @Override
    public String toString() {
        return "회원님의 가입정보입니다." + "\n" +
                "이메일 = " + email + '\n' +
                "비밀번호 = " + password + '\n';
    }
}
    public class homework3BasicClass2 {
        public static void main(String[] args) {
            //회원가입
            Scanner scan1 = new Scanner(System.in);
            System.out.println("이메일을 입력하세요 : ");
            String email = scan1.next();

            Scanner scan2 = new Scanner(System.in);
            System.out.println("비밀번호를 입력하세요 : ");
            String password = scan2.next();

            //회원정보 저장
            MemberInfo member1 = new MemberInfo();
            member1.setEmail(email);
            member1.setPassword(password);

            //입력정보확인
            System.out.println(member1);
        }
    }
