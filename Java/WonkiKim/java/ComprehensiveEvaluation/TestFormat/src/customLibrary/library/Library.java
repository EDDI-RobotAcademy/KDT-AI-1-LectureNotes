package customLibrary.library;

import customLibrary.library.component.Book;
import customLibrary.library.component.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Library {
    final private List<Member> memberList;
    final private HashMap<Book, Integer> bookList;

    public Library() {
        this.bookList = new HashMap<>();
        this.memberList = new ArrayList<>();
    }

    public void add(Book book, int numberOfBook) {
        if (bookList.containsKey(book)) {
            bookList.put(book, Integer.valueOf(numberOfBook) + bookList.get(book));
        } else {
            bookList.put(book, Integer.valueOf(numberOfBook));
        }
    }

    public boolean lend(Book book) {
        if (bookList.get(book) < 1) {
            return false;
        } else {
            bookList.replace(book, bookList.get(book) - 1);
            return true;
        }
    }

    public void addMember(Member member) {
        memberList.add(member);
        member.joinLibrary(this);
    }
}
