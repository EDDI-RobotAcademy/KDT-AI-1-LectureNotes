package customLibrary.prob16;

import java.util.ArrayList;

public class User {
    String libraryId;
    int libraryPw;
    ArrayList<Book> checkOutBook = new ArrayList<>();

    public User(){}

    public String getLibraryId() {
        return libraryId;
    }

    public int getLibraryPw() {
        return libraryPw;
    }

    public ArrayList<Book> getCheckOutBook() {
        return checkOutBook;
    }

    public void setLibraryId(String libraryId) {
        this.libraryId = libraryId;
    }

    public void setLibraryPw(int libraryPw) {
        this.libraryPw = libraryPw;
    }

    public void setCheckOutBook(ArrayList<Book> checkOutBook) {
        this.checkOutBook = checkOutBook;
    }

    @Override
    public String toString() {
        return "User{" +
                "libraryId='" + libraryId + '\'' +
                '}';
    }
}
