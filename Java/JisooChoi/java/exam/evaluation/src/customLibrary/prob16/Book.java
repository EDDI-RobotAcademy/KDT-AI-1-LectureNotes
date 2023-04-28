package customLibrary.prob16;

public class Book {
    String bookName;
    boolean Available = true;

    public Book(String bookName) {
        this.bookName = bookName;
    }

    public String getBookName() {
        return bookName;
    }

    public boolean isAvailable() {
        return Available;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAvailable(boolean available) {
        Available = available;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                '}';
    }
}
