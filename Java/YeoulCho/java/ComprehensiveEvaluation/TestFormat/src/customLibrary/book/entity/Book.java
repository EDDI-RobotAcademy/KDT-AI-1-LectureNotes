package customLibrary.book.entity;

import customLibrary.utility.generator.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class Book { // id, 책이름, 재고,빌려간리스트

    private final int id;
    private final String bookName;
    private int stockCount;
    private final List<BorrowBook> borrowBookList;

    public Book(String bookName, int stockCount) {
        this.id = IdGenerator.getSpecificEntityId("Book");
        this.bookName = bookName;
        this.stockCount =stockCount;
        borrowBookList = new ArrayList<>();
    }

    public int getStockCount() {
        return stockCount;
    }

    public void subtractStockCount(){
        stockCount--; //재고에서 빼는 메서드
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", stockCount=" + stockCount +
                ", borrowBookList=" + borrowBookList +
                '}';
    }
}
