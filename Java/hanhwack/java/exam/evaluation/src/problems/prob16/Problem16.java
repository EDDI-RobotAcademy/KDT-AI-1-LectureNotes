package problems.prob16;

import customLibrary.book.BookLibrary;

public class Problem16 {
    public static void main(String[] args) {
        // 16 ~ 19번 모두 풀었습니다.
        final BookLibrary bookLibrary = new BookLibrary();
        bookLibrary.registerAccount();


        //System.out.println(bookLibrary);
        bookLibrary.borrowBook();
        System.out.println(bookLibrary);
    }
}