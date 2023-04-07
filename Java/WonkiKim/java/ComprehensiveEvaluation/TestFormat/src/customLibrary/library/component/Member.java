package customLibrary.library.component;

import customLibrary.library.Library;

import java.util.ArrayList;
import java.util.List;

public class Member {
    final private List<Book> bookLentalList;
    final private String name;
    private Library library;

    public Member(String name) {
        this.bookLentalList = new ArrayList<>();
        this.name = name;
    }

    public void borrow(Book book) {
        if (library.lend(book)) {
            bookLentalList.add(book);
            System.out.println(this + "가 " + book + "을 1권 대여함.");
        } else System.out.println(book + "재고 부족으로 대여 불가");
    }

    public void joinLibrary(Library library) {
        this.library = library;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                '}';
    }
}
