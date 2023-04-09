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
    }
}
