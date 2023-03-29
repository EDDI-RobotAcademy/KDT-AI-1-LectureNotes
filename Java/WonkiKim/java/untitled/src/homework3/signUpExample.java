package homework3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Window {
    final static private MemberArrayList memberArrayList = new MemberArrayList();
    final private IdInput idInput;
    final private PasswordInput passwordInput;

    public Window() {
        idInput = new IdInput();
        passwordInput = new PasswordInput();
    }

    public void signUp() {

        final String ID = idInput.scan();
        System.out.println();

        final String PASSWORD = passwordInput.scan();

        Member signUpMember = new Member(ID, PASSWORD);
        memberArrayList.add(signUpMember);

        confirm(ID);
    }

    public void confirm(String memberId) {
        System.out.print(memberArrayList.confirm(memberId));
        System.out.println("\n가입 확인되었습니다.");
    }
}

class IdInput {
    final static private Scanner scan = new Scanner(System.in);

    public static String scan() {
        System.out.print("이메일 주소를 입력해주세요: ");
        return scan.nextLine();
    }
}

class PasswordInput {
    final static private Scanner scan = new Scanner(System.in);

    public static String scan() {
        System.out.println("비밀 번호를 입력하세요: ");
        return scan.nextLine();
    }
}

class Member {
    final private String memberId;
    final private String memberPassword;

    public Member(String memberId, String memberPassword) {
        this.memberId = memberId;
        this.memberPassword = memberPassword;
    }

    public String toString() {
        return "ID: " + memberId + "\n" + "PASSWORD: " + memberPassword;
    }

    public String getMemberId() {
        return memberId;
    }
}

class MemberArrayList {
    final static ArrayList<Member> memberArrayList = new ArrayList<>();

    public void add(Member member) {
        memberArrayList.add(member);
    }

    public Member confirm(String memberId) {
        Iterator<Member> ir = memberArrayList.iterator();

        while (ir.hasNext()) {
            Member savedMember = ir.next();
            if ( savedMember.getMemberId() == memberId) {
                return savedMember;
            }
        }

        return new Member("가입정보 없음", "가입정보 없음");
    }
}

public class signUpExample {
    public static void main(String[] args) {
        Window window = new Window();
        window.signUp();
    }

}
