package solution;


import solution.book.BookLibrary;

public class Problem16 {
    public static void main(String[] args) {
        // 16 ~ 19번 모두 풀었습니다.
        final BookLibrary bookLibrary = new BookLibrary();
        bookLibrary.registerAccount(); // 회원가입 1
        bookLibrary.registerAccount(); // 회원가입 2

        //System.out.println(bookLibrary);
        bookLibrary.borrowBook(); // 책 대여
        System.out.println(bookLibrary);
    }
}
