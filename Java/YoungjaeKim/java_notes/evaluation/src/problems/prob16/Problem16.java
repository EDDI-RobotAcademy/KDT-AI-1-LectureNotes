package problems.prob16;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import customLibrary.Book;
import customLibrary.Register;

// 16번, 17번 해결
public class Problem16 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<String>();

        System.out.print("아이디 입력 : ");
        String ID = scanner.nextLine();
        System.out.print("패스워드 입력 : ");
        String PW = scanner.nextLine();
        System.out.print("이름 입력 : ");
        String name = scanner.nextLine();

        Register register = new Register(ID, PW, name);

        System.out.println("아이디 : " + register.getID() +
                ", 패스워드 : " + register.getPW() +
                ", 이름 : " + register.getName());

        for (int i = 0; i < 3; i++) {
            System.out.print("책 입력 : ");
            String bookName = scanner.nextLine();
            Book book = new Book(bookName);
            list.add(book.getBook());
        }

        System.out.println(list);
    }
}
