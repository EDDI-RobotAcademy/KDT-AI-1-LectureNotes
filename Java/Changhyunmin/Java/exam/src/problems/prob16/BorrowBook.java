package problems.prob16;

public class BorrowBook {
    int ID;
    int BookID;
    int AccountID;

    public BorrowBook(int bookID, int accountID) {
        this.ID = IdGenerator.getSpecificEntityID("Book");
        this.BookID = bookID;
        this.AccountID = accountID;
    }

    @Override
    public String toString() {
        return "BorrowBook{" +
                "ID=" + ID +
                ", BookID=" + BookID +
                ", AccountID=" + AccountID +
                '}';
    }
}
