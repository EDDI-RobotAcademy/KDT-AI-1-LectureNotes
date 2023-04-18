package book;

import book.entity.Account;
import book.entity.Book;
import book.entity.BorrowBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookLibrary {
    final private List<Account> accountList;
    final private List<Book> bookList;
    final private List<BorrowBook> borrowBookList;
    final private Scanner scanner;

    // 17번 문제 임의의 책 3권을 추가
    private void presetBookList() {
        bookList.add(new Book("20대 공부해라", 1));
        bookList.add(new Book("30대 공부해라", 2));
        bookList.add(new Book("40대 공부해라", 3));
    }

    // 생성자로 리스트를 초기화해줌
    public BookLibrary() {
        accountList = new ArrayList<>();
        bookList = new ArrayList<>();
        borrowBookList = new ArrayList<>();

        // private void presetBookList()를 위해 만들어준 코드
        presetBookList();

        scanner = new Scanner(System.in);
    }

    // 16번 회원 가입문제
    // 출력을 관리하는 클래스에서 sout 을 사용하지 않고 깔끔하게 출력하는 방법으로 사용함
    public void registerAccount() {
        System.out.println("회원 id를 입력하세요: ");
        final String accountId = scanner.nextLine();

        System.out.println("회원 비밀번호를 입력하세요: ");
        final String password = scanner.nextLine();

        // 위 scanner에 입력받은 accountId와 password를
        // Account 클래스를 가져오면서 매개변수로 추가해줌
        final Account account = new Account(accountId, password);
        accountList.add(account);
    }
    // 출력을 관리하는 클래스에서 sout 을 사용하지 않고 깔끔하게 출력하는 방법으로 사용함
    public void borrowBook() {
        Boolean reDoProcess = false;

        // do while은 무조건 한번이상을 돌아야하는 조건문
        do {
         printBookListInfo();
         final int bookIdForBorrow = inputBookIdNumberForBorrow(); // 책 빌리기
         final String accountId = inputMemberId();                 // 아이디 입력하기
         final String password = inputMemberPassword();            // 비밀번호 입력하기
         final Account searchedAccount = finalByAccountId(accountId);  // 아이디찾기

         // 단일 느낌표는 오른쪽에 붙은 피연산자를 true 혹은 false 로 변환해주는 기능을 갖고 있다.
         // 주로 false 를 의미하는 연산자로 사용된다고 한다.
         // canBorrowBook 메서드가 false 값을 반환하면 sout 이 나옴
         // true 가 반환된다면 이 코드를 스킵하고 다음으로 넘어감
         if (!canBorrowBook(bookIdForBorrow)) {
             System.out.println("선택한 책은 더 이상 빌릴 수 없습니다! (다시 선택해주세요)");
             reDoProcess = true;
             continue;
         }

         // equals() 은 비밀번호가 동일한지아닌지 판단하는 메서드
         if (!searchedAccount.getPassword().equals(password)) {
             System.out.println("잘못된 정보를 기입하였습니다! (다시 입력하세요)");
             reDoProcess = true;
             continue;
         }

         //
         final BorrowBook borrowBook = new BorrowBook(bookIdForBorrow, searchedAccount.getId());
         borrowBookList.add(borrowBook);
         final Book book = bookList.get(bookIdForBorrow);
         // book 클래스에 매서드가 생성됨
         // 재고 수량을 감소시킨다.
         book.subtractStockCount();

         // checkWantToMoreBorrow 메서드를 생성했음
         reDoProcess = checkWantToMoreBorrow();
        } while (reDoProcess);
    }

//--------------------------------- 이 아래는 모두 위에 생성한 매서드를 받기위한 코드 --------

    private boolean canBorrowBook(int bookIdForBorrow) {
        final Book book = bookList.get(bookIdForBorrow);
        final int stockCount = book.getStockCount();

        if (stockCount == 0) { return false; }

        return true;
    }

    private Boolean checkWantToMoreBorrow() {
        Boolean wrongValue = true;
        do {
            System.out.println("계속 빌리시곘습니까 (y / n)?");
            final String inputString = scanner.nextLine();

            if (inputString.equals("y")) {
                return false;
            }
            if (inputString.equals("n")) {
                return false;
            }
        } while (wrongValue);

        return false;
    }

    private String inputMemberPassword() {
        System.out.println("회원님의 비밀번호를 입력하세요: ");
        final String password = scanner.nextLine();
        return password;
    }

    private String inputMemberId() {
        System.out.println("회원님의 id를 입력하세요: ");
        final String accountId = scanner.nextLine();
        return accountId;
    }

    private int inputBookIdNumberForBorrow() {
        System.out.println("빌리고 싶은 책의 id 번호를 입력하세요: ");
        final int inputBookId = scanner.nextByte();
        scanner.nextLine();
        return inputBookId;
    }

    private void printBookListInfo() {
        System.out.println("현재 빌릴 수 있는 책 리스트를 출력합니다!");
        System.out.println(bookList);
    }

    private Account finalByAccountId(String accountId) {
        for (int i = 0; i < accountList.size(); i++) {
            final Account searchedAccount = accountList.get(i);
            final String searchedAccountId = searchedAccount.getAccountId();
            System.out.println("searchedAccountId: " + searchedAccountId);

            if (searchedAccountId.equals(accountId)) {
                return searchedAccount;
            }
        }

        return null;

    }

    @Override
    public String toString() {
        return "BookLibrary{" +
                "accountList=" + accountList +
                ", bookList=" + bookList +
                ", borrowBookList=" + borrowBookList +
                ", scanner=" + scanner +
                '}';
    }
}
