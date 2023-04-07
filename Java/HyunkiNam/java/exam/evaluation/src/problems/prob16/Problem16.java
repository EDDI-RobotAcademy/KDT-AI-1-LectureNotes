package problems.prob16;

public class Problem16 {
    public static void main(String[] args) {
        // 16 ~ 19번까지 모두 완료했습니다
        BookManager bookManager = new BookManager();

        bookManager.addCustomer();
        bookManager.addMoreCustomer();
        bookManager.addBook();
        bookManager.borrowBook();

        System.out.println(bookManager);
    }
}
