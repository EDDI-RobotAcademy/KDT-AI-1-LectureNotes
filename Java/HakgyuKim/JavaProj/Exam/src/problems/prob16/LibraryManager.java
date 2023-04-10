package problems.prob16;

import customLibrary.CustomRandom;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class LibraryManager {
    private HashMap<String, Integer> bookMap = new HashMap<>();
    final private int NUM_OF_BOOKS = 3;
    private int BOOK_COUNT;
    LibraryMember libraryMember;
    Scanner scanner = new Scanner(System.in);

    public LibraryManager() {
        libraryMember = new LibraryMember();
        addBooks();


    }

    private void addBooks() {
        for (int i = 0; i < NUM_OF_BOOKS; i++) {
            BOOK_COUNT = CustomRandom.generateNumber(3);
            bookMap.put("책" + (i+1), BOOK_COUNT);
        }
    }

    public HashMap<String, Integer> getBookMap() {
        return bookMap;
    }

    public void borrowBook() {
        System.out.println("빌리고 싶은 책의 이름을 입력하세요");
        String bookSelect = scanner.next();

        if (bookMap.get(bookSelect) == 0) {
            System.out.println("현재 책은 수량이 부족합니다 다른 책을 빌리세요");
        } else {
            bookMap.replace(bookSelect,bookMap.get(bookSelect) - 1);
            System.out.println(libraryMember.getEmail() + " 님이 " +
                               bookSelect + "을 빌리고 현재 남은 수량은: " +
                               bookMap.get(bookSelect) + " 입니다.");
        }
    }

    public LibraryMember getLibraryMember() {
        return libraryMember;
    }
}
