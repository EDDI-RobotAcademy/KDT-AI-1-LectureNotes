package problems.prob16;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private int ID;
    private String BookName;
    private int StockCount;
    private List<BorrowBook>borrowList;

    public Book(String bookName, int stockCount) {
        this.ID = IdGenerator.getSpecificEntityID("Book");
        this.BookName = bookName;
        this.StockCount = stockCount;

        borrowList = new ArrayList<>();
    }

    public int getStockCount() {
        return StockCount;
    }
    void subtractStockCount(){
        StockCount--;
    }

    public Book(int ID, String bookName, int stockCount) {
        this.ID = ID;
        BookName = bookName;
        StockCount = stockCount;
    }
}
