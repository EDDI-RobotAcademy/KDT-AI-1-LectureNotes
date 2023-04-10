package problems.prob16;

import customLibrary.CustomRandom;

public class Book {
    final String bookName;
    final int MIN_COUNT = 1;
    final int MAX_COUNT = 3;
    int count;
    public Book(String bookName){
        this.bookName = bookName;
        this.count = CustomRandom.generateNumber(MIN_COUNT,MAX_COUNT);
    }

    public String getBookName() {
        return bookName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "{bookName='" + bookName + '\'' +
                ", count=" + count +
                '}';
    }
}
