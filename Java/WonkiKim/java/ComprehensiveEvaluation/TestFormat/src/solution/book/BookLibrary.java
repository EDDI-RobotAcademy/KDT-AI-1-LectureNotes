package solution.book;

import solution.book.entity.Account;
import solution.book.entity.Book;
import solution.book.entity.BorrowBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookLibrary {
    final private List<Account> accountList;
    final private List<Book> bookList;
    final private List<BorrowBook> borrowBookList;
    final private Scanner scanner;

    private void presetBookList() { // 도서관의 초기 책 세팅
        bookList.add(new Book("20대 공부해라", 1));
        bookList.add(new Book("30대 공부해라", 2));
        bookList.add(new Book("40대 공부해라", 1));
    }
    public BookLibrary() { // BookLibrary 클래스 생성자
        accountList = new ArrayList<>();
        bookList = new ArrayList<>();
        borrowBookList = new ArrayList<>();

        presetBookList();

        scanner = new Scanner(System.in);
    }
    public void registerAccount() {  //회원가입 메소드
        System.out.print("회원 id를 입력하세요: ");
        final String accountId = scanner.nextLine();

        System.out.print("회원 비밀번호를 입력하세요: ");
        final String password = scanner.nextLine();

        final Account account = new Account(accountId, password);
        accountList.add(account);
    }

    public void borrowBook() {
        Boolean reDoProcess = false; // 예상 되지 않는 입력값일 경우 아래 do while문을 다시 실행 하기위한 boolean

        do {
            printBookListInfo(); //현재 BookLibrary 인스턴스가 소장하고 있는 책 목록은 출력
            final int bookIdForBorrow = inputBookIdNumberForBorrow();
            final String accountId = inputMemberId();
            final String password = inputMemberPassword();
            final Account searchedAccount = findByAccountId(accountId); // 해당하는 아이디가 존재하는지 확인

            if (!canBorrowBook(bookIdForBorrow)) {//book의 stockCount가 0이라면 false 1이상이라면 true를 리턴함.
                System.out.println("선택한 책은 더 이상 빌릴 수 없습니다! (다시 선택해주세요)");
                reDoProcess = true;
                continue;
            }

            // 회원 id로 정보 조회
            System.out.println("searchedAccount: " + searchedAccount);
            if (searchedAccount == null) { // findByAccountId에서 Accuount 객체가 아닌 null값을 반환받았다면.
                System.out.println("잘못된 정보를 기입하였습니다! (다시 입력하세요)");
                reDoProcess = true;
                continue;
            }

            if (!searchedAccount.getPassword().equals(password)) { //Account객체의 password 와 입련한password가 다르다면,
                System.out.println("잘못된 정보를 기입하였습니다! (다시 입력하세요)");
                reDoProcess = true;
                continue;
            }

            final BorrowBook borrowBook =
                    new BorrowBook(bookIdForBorrow, searchedAccount.getId()); //위에서 잘못 입력된 정보가 없다면, BorrowBook 객체를 생성
            borrowBookList.add(borrowBook);
            final Book book = bookList.get(bookIdForBorrow); //Book.subtractStockCount()를 실행시키기 위해 Book객체를 생성
            book.subtractStockCount();//book객체의 stockCount를 하나 줄임.

            reDoProcess = checkWantToMoreBorrow();
        } while (reDoProcess);
    }

    private boolean canBorrowBook(int bookIdForBorrow) {
        final Book book = bookList.get(bookIdForBorrow);
        final int stockCount = book.getStockCount();

        if (stockCount == 0) { return false; }

        return true;
    }

    private Boolean checkWantToMoreBorrow () {
        Boolean wrongValue = true;
        do {
            System.out.print("계속 빌리시겠습니까 (y / n) ? ");
            final String inputString = scanner.nextLine();

            if (inputString.equals("y")) {
                return true;
            }
            if (inputString.equals("n")) {
                return false;
            }
        } while (wrongValue);

        return false;
    }

    private String inputMemberPassword() {
        System.out.print("회원님의 비밀번호를 입력하세요: ");
        final String password = scanner.nextLine();
        return password;
    }

    private String inputMemberId() {
        System.out.print("회원님의 id를 입력하세요: ");
        final String accountId = scanner.nextLine();
        return accountId;
    }

    private int inputBookIdNumberForBorrow() {
        System.out.print("빌리고 싶은 책의 id 번호를 입력하세요: ");
        final int inputBookId = scanner.nextInt();
        scanner.nextLine();
        return inputBookId;
    }

    private void printBookListInfo() {
        System.out.println("현재 빌릴 수 있는 책 리스트를 출력합니다!");
        System.out.println(bookList);
    }

    private Account findByAccountId(String accountId) {
        for (int i = 0; i < accountList.size(); i++) {//아이디리스트 전체를 돌아감.
            final Account searchedAccount = accountList.get(i);
            final String searchedAccountId = searchedAccount.getAccountId();
            System.out.println("searchedAccountId: " + searchedAccountId);

            if (searchedAccountId.equals(accountId)) {
                return searchedAccount;//idList안에 아이디가 있다면 Accuount 객체를 리턴함.
            }
        }

        return null;//없다면 null을 반환.
    }

    @Override
    public String toString() {
        return "BookLibrary{" +
                "accountList=" + accountList +
                ", bookList=" + bookList +
                ", borrowBookList=" + borrowBookList +
                '}';
    }
}
