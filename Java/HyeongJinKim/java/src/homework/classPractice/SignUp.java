package homework.classPractice;

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