package examSolve.exam1.pro16;

import examSolve.exam1.customLibrary.book.BookLibrary;

public class Pro16 {
    public static void main(String[] args) {
        BookLibrary bookLibrary = new BookLibrary();
        // 두 회원 생성
        bookLibrary.registerAccount();
        bookLibrary.registerAccount();

        // 책 빌리기
        bookLibrary.borrowBook();
        System.out.println(bookLibrary);
    }
}
