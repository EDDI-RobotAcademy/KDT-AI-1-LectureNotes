package book;

public class Problem16 {
    public static void main(String[] args) {
        BookLibrary bookLibrary = new BookLibrary();
        bookLibrary.registerAccount();

//        System.out.println(bookLibrary);
        bookLibrary.borrowBook();
        System.out.println(bookLibrary);
    }
}
