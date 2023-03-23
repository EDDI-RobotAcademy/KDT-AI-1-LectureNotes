package homework.third;

import java.util.Scanner;

class Member{
    private String email = "";
    private int num = 0;

    public Member(String email, int num){
        this.email = email;
        this.num = num;

        setEmailAndNum(email, num);
    }

    public void setEmailAndNum(String email, int num) {
        if((email != "") && (num != 0)){  // Q. int 타입의 null 표시는 어떻게 할 수 있나요 ?
            System.out.println("올바르게 기입되었습니다.");
        }
        else{
            System.out.println("빈칸 없이 기입해주세요.");
        }
    }
}

public class SignUpClass {
    public static void main(String[] args) {
        System.out.println("이메일 주소와 비밀번호를 입력해주세요 > ");
        Scanner scanEmail = new Scanner(System.in);
        Scanner scanNum = new Scanner(System.in);

        String email = scanEmail.nextLine();
        int num = scanNum.nextInt();

        Member hong = new Member(email, num);
    }
}