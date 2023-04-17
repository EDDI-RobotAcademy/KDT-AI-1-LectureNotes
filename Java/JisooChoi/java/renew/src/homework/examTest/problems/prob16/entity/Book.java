package homework.examTest.problems.prob16.entity;

import utility.generator.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private final int id;
    private final String bookName;
    private int stockCount;
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
        stockCount--;
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
