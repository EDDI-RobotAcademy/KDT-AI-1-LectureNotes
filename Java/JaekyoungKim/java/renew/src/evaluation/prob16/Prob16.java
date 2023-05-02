package evaluation.prob16;

public class Prob16 {
    public static void main(String[] args) {
        final BookLibrary bookLibrary = new BookLibrary();// 북라이브러리 생성
        bookLibrary.registerAccount();
        bookLibrary.registerAccount();

        //System.out.println(bookLibrary);
        bookLibrary.borrowBook();
        System.out.println(bookLibrary);
    }
}
