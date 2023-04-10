package problems.prob16;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer {
    final String name;
    final String password;
    List<String> borrowBookList;

    public Customer(){
        Scanner sc = new Scanner(System.in);
        System.out.println("아이디 입력");
        this.name = sc.next();
        System.out.println("패스워드 입력");
        this.password = sc.next();
        this.borrowBookList = new ArrayList<>();
    }

    public void setBorrowBookList(String bookName) {
        borrowBookList.add(bookName);
    }

    @Override
    public String toString() {
        return "{name='" + name + '\'' +
                ", borrowBookList=" + borrowBookList +
                '}';
    }
}
