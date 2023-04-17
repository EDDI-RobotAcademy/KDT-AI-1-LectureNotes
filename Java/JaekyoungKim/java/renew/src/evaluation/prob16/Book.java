package evaluation.prob16;

import utility.generator.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private final int id;// 책 일련 번호
    private final String bookName;//책이름
    private int stockCount;//남은 수량
    private final List<BorrowBook> borrowList;

    public Book(String bookName, int stockCount) {
        this.id = IdGenerator.getSpecificEntityId("Book");
        this.bookName = bookName;
        this.stockCount = stockCount;

        borrowList = new ArrayList<>();
    }

    public int getStockCount() {
        return stockCount;
    }

    public void subtractStockCount() {
        stockCount--;//빌렸을 경우 수량을 1 줄임
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", stockCount=" + stockCount +
                '}' + '\n';
    }
}

