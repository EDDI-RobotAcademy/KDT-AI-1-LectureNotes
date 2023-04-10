package problems.prob16;

public class StockOfBook {
    int totalStockOfBook;

    public StockOfBook(int totalStockOfBook) {
        this.totalStockOfBook = totalStockOfBook;
    }
    public void reduceStock(int rentalBookNumber){
        this.totalStockOfBook -= rentalBookNumber;
    }

    public int getTotalStockOfBook() {
        return totalStockOfBook;
    }
}
