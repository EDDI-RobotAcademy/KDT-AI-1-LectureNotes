package homework.examTest.problems.prob16.book;

import homework.examTest.problems.prob16.entity.Account;
import homework.examTest.problems.prob16.entity.Book;
import homework.examTest.problems.prob16.entity.BorrowBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookLibrary {
    final private List<Account> accountList; // 회원들이 들어갈 리스트
    final private List<Book> bookList; // 책들이 들어갈 리스트
    final private List<BorrowBook> borrowBookList; // 빌린 책 목록이 들어갈 리스트
    final private Scanner scanner;

    private void presetBookList() {
        // 책 객체는 이름과 책의 수량을 가지고 있다.
        bookList.add(new Book("20대 공부해라", 1));
        bookList.add(new Book("30대 공부해라", 2));
        bookList.add(new Book("40대 공부해라", 1));
    }

    public BookLibrary() {
        // 도서관 객체를 만들면서 생성되는 것들
        accountList = new ArrayList<>();
        bookList = new ArrayList<>();
        borrowBookList = new ArrayList<>();

        // 도서관 임의의 책
        presetBookList();

        scanner = new Scanner(System.in);
    }

    // 회원가입 메서드
    public void registerAccount() {
        System.out.print("회원 id를 입력하세요: ");
        final String accountId = scanner.nextLine();

        System.out.print("회원 비밀번호를 입력하세요: ");
        final String password = scanner.nextLine();

        // 기입한 id와 pw를 회원 객체를 만들면서 넣어준다.
        final Account account = new Account(accountId, password);

        // 만들어진 회원 객체를 리스트에 넣는다.
        accountList.add(account);
    }

    // 책 대출 메서드
    public void borrowBook() {
        Boolean reDoProcess = false;

        do {
            // 현재 빌릴 수 있는 책 목록을 출력
            printBookListInfo();

            // 빌리고 싶은 책의 id를 받아온다.
            final int bookIdForBorrow = inputBookIdNumberForBorrow();

            // 회원 id를 받아온다.
            final String accountId = inputMemberId();
            // 회원 비밀번호를 받아온다.
            final String password = inputMemberPassword();

            // 회원 id가 존재하는 지 확인한다.
            final Account searchedAccount = findByAccountId(accountId);

            // 빌리고 싶은 책이 없다면
            if (!canBorrowBook(bookIdForBorrow)) {
                System.out.println("선택한 책은 더 이상 빌릴 수 없습니다! (다시 선택해주세요)\n");
                reDoProcess = true;
                continue;
            }

            // 회원 id로 정보 조회
            System.out.println("searchedAccount: " + searchedAccount);
            if (searchedAccount == null) {
                System.out.println("잘못된 정보를 기입하였습니다! (다시 입력하세요)\n");
                reDoProcess = true;
                continue;
            }

            // 입력한 패스워드와 기존 패스워드가 다른 경우
            if (!searchedAccount.getPassword().equals(password)) {
                System.out.println("잘못된 정보를 기입하였습니다! (다시 입력하세요)\n");
                reDoProcess = true;
                continue;
            }

            final BorrowBook borrowBook = new BorrowBook(bookIdForBorrow, searchedAccount.getId());
            borrowBookList.add(borrowBook);

            final Book book = bookList.get(bookIdForBorrow);
            // 빌린 책의 수량을 1 뺀다.
            book.subtractStockCount();

            // 계속 빌릴지에 대한 여부 묻기
            reDoProcess = checkWantToMoreBorrow();
        } while (reDoProcess);
    }

    // 빌릴 수 있는지 없는지 확인
    private boolean canBorrowBook(int bookIdForBorrow) {
        final Book book = bookList.get(bookIdForBorrow); // -> 형태가 낯섬(new가 없는디?)
        // final Book book = new Book(); 객체 생성하고
        // bookList.get(빌리고 싶은 책의 아이디 값); 리스트에 있는 책 가져와서
        // book 에 넣어주어라

        // 재고 확인
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
        System.out.print("\n빌리고 싶은 책의 id 번호를 입력하세요: ");
        final int inputBookId = scanner.nextInt();
        scanner.nextLine();
        return inputBookId;
    }

    private void printBookListInfo() {
        System.out.println("\n현재 빌릴 수 있는 책 리스트를 출력합니다!");
        System.out.println(bookList);
    }

    private Account findByAccountId(String accountId) {
        for (int i = 0; i < accountList.size(); i++) {
            final Account searchedAccount = accountList.get(i);
            final String searchedAccountId = searchedAccount.getAccountId();
            System.out.println("searchedAccountId: " + searchedAccountId);

            // 기입한 아이디와 리스트에 들어간 아이디가 맞는 지 확인.
            if (searchedAccountId.equals(accountId)) {
                return searchedAccount;
                // 맞다면, 계정 정보를 리턴해주고
            }
        }

        // 아니라면, 널 값을 리턴해주면 된다.
        return null;
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
