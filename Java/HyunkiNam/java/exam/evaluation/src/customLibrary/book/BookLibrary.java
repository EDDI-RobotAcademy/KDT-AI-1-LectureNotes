package customLibrary.book;

import customLibrary.book.entity.Account;
import customLibrary.book.entity.Book;
import customLibrary.book.entity.BorrowBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookLibrary {
    final private List<Account> accountList;
    final private List<Book> bookList;
    final private List<BorrowBook> borrowBookList;
    final private Scanner scanner;

    // 17번 임의의 책 3권 리스트에 추가
    private void presetBookList() {
        bookList.add(new Book("20대 공부해라", 1));
        bookList.add(new Book("30대 공부해라", 2));
        bookList.add(new Book("40대 공부해라", 1));
    }
    public BookLibrary() {
        accountList = new ArrayList<>();
        bookList = new ArrayList<>();
        borrowBookList = new ArrayList<>();

        presetBookList();

        scanner = new Scanner(System.in);
    }
    // 16번 회원가입, id와 password 리스트에 추가
    public void registerAccount() {
        System.out.print("회원 id를 입력하세요: ");
        final String accountId = scanner.nextLine();

        System.out.print("회원 비밀번호를 입력하세요: ");
        final String password = scanner.nextLine();

        final Account account = new Account(accountId, password);
        accountList.add(account);
    }

    //
    public void borrowBook() {
        Boolean reDoProcess = false;

        do {
            printBookListInfo();
            final int bookIdForBorrow = inputBookIdNumberForBorrow(); // 빌릴 책 선택
            final String accountId = inputMemberId(); // 아이디 입력
            final String password = inputMemberPassword(); // 패스워드 입력
            final Account searchedAccount = findByAccountId(accountId); // 유효한 계정인지 체크

            if (!canBorrowBook(bookIdForBorrow)) {
                System.out.println("선택한 책은 더 이상 빌릴 수 없습니다! (다시 선택해주세요)");
                reDoProcess = true;
                continue;
            }

            // 회원 id로 정보 조회
            System.out.println("searchedAccount: " + searchedAccount);
            if (searchedAccount == null) {
                System.out.println("잘못된 정보를 기입하였습니다! (다시 입력하세요)");
                reDoProcess = true;
                continue;
            }

            if (!searchedAccount.getPassword().equals(password)) {
                System.out.println("잘못된 정보를 기입하였습니다! (다시 입력하세요)");
                reDoProcess = true;
                continue;
            }

            final BorrowBook borrowBook =
                    new BorrowBook(bookIdForBorrow, searchedAccount.getId());
            borrowBookList.add(borrowBook); // 빌릴 책과 대여자의 id를 리스트에 추가
            final Book book = bookList.get(bookIdForBorrow);
            book.subtractStockCount(); // 빌릴 책 수량 -1

            reDoProcess = checkWantToMoreBorrow();
        } while (reDoProcess);
    }

    private boolean canBorrowBook(int bookIdForBorrow) {
        // 빌리고자 하는 책의 수량 체크
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

            // y 입력시 더 빌리겠다는 뜻으로 true를 리턴하고 그렇기때문에 borrowBook 메소드가 한번 더 실행
            // y 나 n 값이 아니면 다시 물어보게 do-while문으로 작성
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
        // accountList에 있는 id를 받아오며 입력된 id값과 비교하고 값이 같다면 리턴
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
                '}';
    }
}