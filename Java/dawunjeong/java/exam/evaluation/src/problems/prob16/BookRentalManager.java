package problems.prob16;

import customLibrary.GeneratorSequence;
import customLibrary.RandomGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookRentalManager {
    List<Member> memberList;
    List<Book> bookList;

    public BookRentalManager() {
        memberList = new ArrayList<>();
        bookList = new ArrayList<>();
    }

    public void addMember () {

        String email;
        String password;
        Scanner scan = new Scanner(System.in);
        email = scan.next();
        password = scan.next();

        memberList.add(new Member(
                GeneratorSequence.getSpecificEntityId("Member"),
                email, password));
    }

    public void printMemberList () {
        for (Member member: memberList) {
            System.out.println(member);
        }
    }

    public void addRandomBook() {
        final int BOOK_MIN = 1;
        final int BOOK_MAX = 10;

        final String[] bookNameArray = { "책1", "책2", "책3" };
        final String publisher = "비상";

        for (int i = 0; i < bookNameArray.length; i++) {
            int stockOfBook = RandomGenerator.generateNumber(BOOK_MIN, BOOK_MAX);
            bookList.add(new Book(
                    bookNameArray[i], publisher, stockOfBook));
        }
    }

    public void printBookList () {
        for (Book book: bookList) {
            System.out.println(book);
        }
    }

    public void rentalRandomBook() {
        final int MIN = 0;
        final int MAX = (memberList.size() - 1);

        int bookLength = bookList.size();

        for (int i = 0; i < bookLength; i++) {
            Book book = bookList.get(
                    RandomGenerator.generateNumber(2));
            book.stockOfBookNumber.reduceStock(1);

            book.setMemberId(
                    RandomGenerator.generateNumber(MIN, MAX));
        }

    }

}
