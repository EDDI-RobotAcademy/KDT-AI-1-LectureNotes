package homework;

import java.util.Scanner;

    class Member {
        private String id;
        private String pw;

        public Member() {
        }

        public String getId() {
            return id;
        }

        public void setId(Scanner scan) {
            System.out.print("아이디를 입력하세요: ");
            this.id = scan.next();
        }

        public String getPw() {
            return pw;
        }

        public void setPw(Scanner scan) {
            System.out.print("비밀번호를 입력하세요: ");
            this.pw = scan.next();
        }
    }

    public class SignUp {
        public static void main(String[] args) {
            Member member = new Member();
            Scanner scan = new Scanner(System.in);

            System.out.println("회원가입");
            member.setId(scan);
            member.setPw(scan);

            System.out.println("회원가입이 완료되었습니다.");
            System.out.printf("ID: %s\nPW: %s", member.getId(), member.getPw());
        }
    }

    /*
    회원(Member) 클래스를 만들어서
    회원 가입을 진행해봅시다!
    회원 이메일 주소와 비밀번호를 입력받습니다.
    입력한 이메일 주소와 비밀번호가 올바르게 들어갔는지 확인해봅시다.
    */