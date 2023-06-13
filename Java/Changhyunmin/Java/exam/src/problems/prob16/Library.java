package problems.prob16;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Library {
    private List<Account> accountList;
    private List<Book>bookList;
    private List<BorrowBook>borrowList;
    private Scanner sc;

    private void presetBookList(){
        bookList.add(new Book("20대 공부해라",1));
        bookList.add(new Book("30대 공부해라",2));
        bookList.add(new Book("40대 공부해라",1));
    }

    public Library() {
        accountList = new ArrayList<>();
        bookList = new ArrayList<>();
        borrowList = new ArrayList<>();

        presetBookList();
        
    }

}

