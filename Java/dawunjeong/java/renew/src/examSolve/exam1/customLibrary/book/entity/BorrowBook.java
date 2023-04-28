package examSolve.exam1.customLibrary.book.entity;

import examSolve.exam1.customLibrary.utility.generator.IdGenerator;

public class BorrowBook {
    private final int id;
    private final int bookId;
    private final int accountId;

    // 책 번호와 회원 번호를 입력받는다.
    public BorrowBook(int bookId, int accountId) {
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
