package solution.book.entity;


import solution.book.customLibrary.IdGenerator;

public class BorrowBook {
    private final int id;
    private final int bookId;
    private final int accountId;

    public BorrowBook(int bookId, int accountId) {
        this.id = IdGenerator.getSpecificEntityId("BorrowBook");//BorrowBook 엔티티의 id밸류 증가
        this.bookId = bookId;
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "BorrowBook{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", accountId=" + accountId +
                '}' + '\n';
    }
}
