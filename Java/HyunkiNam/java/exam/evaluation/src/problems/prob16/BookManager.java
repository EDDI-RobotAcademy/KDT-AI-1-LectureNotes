package problems.prob16;

import customLibrary.CustomRandom;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookManager {
    final int CUSTOMER_NUMBER = 3;
    final int BOOK_NUMBER = 3;
    List<Customer> customerList = new ArrayList<>();
    List<Book> bookList = new ArrayList<>();

    public void addCustomer() {
        for (int i = 0; i < CUSTOMER_NUMBER; i++) {
            customerList.add(new Customer());
        }
    }

    public void addMoreCustomer() {
            customerList.add(new Customer());
    }

    public void addBook(){
        final int BOOK_NAME_LENGTH = 5;
        for(int i=0; i<BOOK_NUMBER; i++){
            StringBuilder str = new StringBuilder();
            for(int j=0; j<BOOK_NAME_LENGTH; j++){
                str.append((char) CustomRandom.generateNumber('a', 'z'));
            }
            bookList.add(new Book(str.toString()));
        }
    }

    public void borrowBook(){
        for(int i=0; i<customerList.size(); i++){
            Customer currentCustomer = customerList.get(i);

            System.out.println("책 목록");
            for(int j=0; j<bookList.size(); j++){
                System.out.println((j+1)+ "." + bookList.get(j).getBookName() + " 남은 수량 : " + bookList.get(j).getCount());
            }

            Scanner sc = new Scanner(System.in);
            int select = sc.nextInt();

            Book selectedBook = bookList.get(select-1);

            if(selectedBook.getCount() == 0){
                System.out.println("수량 부족");
            }else {
                currentCustomer.setBorrowBookList(selectedBook.getBookName());
                selectedBook.setCount(selectedBook.getCount()-1);
            }
        }
    }

    @Override
    public String toString() {
        return "customerList=" + customerList +
                "\nbookList=" + bookList +
                '}';
    }
}
