package problems.prob16;

import java.util.ArrayList;
import java.util.List;

public class Book {
    final private String bookName;
    final private String publisher;
    private int stockOfBook;
    private List<Integer> memberIdList;
    StockOfBook stockOfBookNumber;

    public Book(String bookName, String publisher, int stockOfBook) {
        this.bookName = bookName;
        this.publisher = publisher;
        this.stockOfBook = stockOfBook;
        this.memberIdList = new ArrayList<>();
        stockOfBookNumber = new StockOfBook(stockOfBook);
    }

    public void setMemberId(int memberId) {
        memberIdList.add(memberId);
    }

    public List<Integer> getMemberIdList() {

        return memberIdList;
    }

    public String getBooktName() {
        return bookName;
    }

    public int getStockOfBook() {
        return stockOfBook;
    }

    public StockOfBook getStockOfBookNumber() {
        return stockOfBookNumber;
    }

    @Override
    public String toString() {
        return "RefactorProduct{" +
                "bookName='" + bookName + '\'' +
                ", publisher='" + publisher + '\'' +
                ", stockOfBook=" + stockOfBook +
                ", memberIdList=" + memberIdList +
                '}';
    }
}
