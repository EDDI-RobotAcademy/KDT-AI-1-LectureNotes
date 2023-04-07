package problems.prob16;

import customLibrary.library.component.Book;
import customLibrary.library.Library;
import customLibrary.library.component.Member;

public class Problem16 {
    public static void main(String[] args) {
        //16, 17, 18, 19 문제 모두 작성함.
        Book book1 = new Book("HP");
        Book book2 = new Book("LOR");
        Book book3 = new Book("GOT");

        Library library = new Library();
        library.add(book1, 1);
        library.add(book2, 1);
        library.add(book3, 1);
        library.add(book1, 1);

        Member member = new Member("member1");
        member.joinLibrary(library);

        member.borrow(book2);
        member.borrow(book1);
        member.borrow(book1);

    }
}
