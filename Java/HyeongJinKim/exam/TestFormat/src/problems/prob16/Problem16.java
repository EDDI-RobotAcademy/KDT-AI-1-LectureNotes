package problems.prob16;

import customLibrary.book.BookLibrary;

public class Problem16 {
    public static void main(String[] args) {
        // 16 ~ 19번 모두 풀었습니다.
        final BookLibrary bookLibrary = new BookLibrary();
        // 1. BookLibrary 호출, 객체 생성

        bookLibrary.registerAccount();
//        bookLibrary.registerAccount();
        // 10. registerAccount 메서드 호출

        //System.out.println(bookLibrary);
        bookLibrary.borrowBook();
        // 15. borrowBook 메서드 호출

        System.out.println(bookLibrary);
    }
}
