package book.entity;

import utility.generate.SequenceGenerator;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private final int id;
    private final String bookName;
    private int stockCount;
    private final List<BorrowBook> borrowList;

    // Book에 이름과 재고를 넣어 BookLibrary 클래스에 메서드를 만들어줄때 사용함
    public Book(String bookName, int stockCount) {
        this.id = SequenceGenerator.getSpecificEntityId("Book");
        this.bookName = bookName;
        this.stockCount = stockCount;

        borrowList= new ArrayList<>();
    }

    public int getStockCount() {
        return stockCount;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", stockCount=" + stockCount +
                '}';
    }

    // 재고의 수량을 감소시키는 매서드
    public void subtractStockCount() {
        stockCount--;
    }
}
