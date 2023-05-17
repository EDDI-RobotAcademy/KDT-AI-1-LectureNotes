package problems.prob16review;

import customLibrary.book.BookLibrary;

public class Problem16Review {
    public static void main(String[] args) {
        // 16 ~ 19번 모두 풀었습니다.
        final BookLibrary bookLibrary = new BookLibrary();
        bookLibrary.registerAccount();
        bookLibrary.registerAccount();

        //System.out.println(bookLibrary);
        bookLibrary.borrowBook();
        System.out.println(bookLibrary);
    }
}