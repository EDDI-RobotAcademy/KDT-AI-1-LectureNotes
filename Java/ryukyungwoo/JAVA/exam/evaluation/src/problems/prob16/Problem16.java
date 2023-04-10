package problems.prob16;

/*
1.  회원 가입이 가능하도록 프로그램을 작성해주세요.

    임의의 책 3권을 도서 관리 목록에 추가해주세요.

    가입된 회원들이 도서를 빌릴 수 있도록 만들어주세요.

    도서에 수량 개념을 도입하여 기존 기능들이 동작하도록 만들어주세요. 재고가 부족한 경우 도서를 빌리지 못하게 만들어주세요.
 */

import java.util.Scanner;

class JoinMember {
    final private String memberId;
    final private String memberPassword;
    Scanner scanner = new Scanner(System.in);
    public JoinMember (String memberId, String memberPassword) {
        memberId = scanner.next();
        memberPassword = scanner.next();
        this.memberId = memberId;
        this.memberPassword = memberPassword;
    }

}

public class Problem16 {
    public static void main(String[] args) {

    }
}
