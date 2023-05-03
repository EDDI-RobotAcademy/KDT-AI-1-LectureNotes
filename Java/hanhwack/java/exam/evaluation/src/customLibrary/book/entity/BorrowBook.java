package customLibrary.book.entity;

import customLibrary.utility.generator.IdGenerator;

public class BorrowBook {
    private final int id;
    private final int bookId;
    private final int accountId;

    public BorrowBook(int bookId, int accountId) {
        // bookId와 accountId를 hash에 저장 value값 id로 리턴
        this.id = IdGenerator.getSpecificEntityId("BorrowBook");
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