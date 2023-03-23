package homework;

import java.util.Scanner;

    class Member{
        final private String Id;
        final private String Pw;

        public Member() {
            this.Id = new Id().getId();
            this.Pw = new Pw().getPw();
        }
    }
    class Id {
        String id;

        public Id() {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    class Pw {
        String pw;

        public Pw() {
            this.pw = pw;
        }

        public String getPw() {
            return pw;
        }

        public void setPw(String pw) {
            this.pw = pw;
        }
    }
public class SignUp {
    public static void main(String[] args) {
        int loopCount = 2;

        while (loopCount != 0) {
            Scanner scan = new Scanner(System.in);

            System.out.print("아이디를 입력하세요: ");
            String inputId = scan.next();
        }
    }
}


    /*
    회원(Member) 클래스를 만들어서
    회원 가입을 진행해봅시다!
    회원 이메일 주소와 비밀번호를 입력받습니다.
    입력한 이메일 주소와 비밀번호가 올바르게 들어갔는지 확인해봅시다.
    */