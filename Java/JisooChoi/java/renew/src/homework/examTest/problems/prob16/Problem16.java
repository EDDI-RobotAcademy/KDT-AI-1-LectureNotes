package homework.examTest.problems.prob16;

import homework.examTest.problems.prob16.book.BookLibrary;

public class Problem16 {
    public static void main(String[] args) {
        // 도서관 객체를 만든다.
        final BookLibrary bookLibrary = new BookLibrary();

        // 도서관 회원가입을 한다.
        bookLibrary.registerAccount();

        // 도서관에서 책을 대출한다.
        bookLibrary.borrowBook();

        // 출력
        System.out.println(bookLibrary);

        // 1. 회원가입
        // 2. 책 리스트 출력(id, name, stockCount)
        // 3. 빌리고 싶은 책 id 입력해라 -> 사용자 id, pw 확인 및 책 대출가능한지 확인
        // 4. 계속 빌릴거냐? (y -> continue /n -> return)
        // 5.

    }
}
