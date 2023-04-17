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

    private void presetBookList() {
        bookList.add(new Book("20대 공부해라", 1));
        bookList.add(new Book("30대 공부해라", 2));
        bookList.add(new Book("40대 공부해라", 1));
    }
    public BookLibrary() {
        accountList = new ArrayList<>();
        bookList = new ArrayList<>();
        borrowBookList = new ArrayList<>();
        // 미리 북리스트에 저장한값 불러오기
        presetBookList();

        scanner = new Scanner(System.in);
    }
    public void registerAccount() {
        System.out.print("회원 id를 입력하세요: ");
        final String accountId = scanner.nextLine();

        System.out.print("회원 비밀번호를 입력하세요: ");
        final String password = scanner.nextLine();

        // accountId password 키보드로 입력받고 Account class 불러서
        // 최종적으로는 IdGenerator이용해서 hash에 저장하고 이 값을 리스트에 저장
        final Account account = new Account(accountId, password);
        accountList.add(account);
    }

    public void borrowBook() {
        Boolean reDoProcess = false;

        do {
            // 책 대여절차
            // bookList 출력
            // 빌리고 싶은 책의 Id 입력
            // 빌릴 회원의 Id입력
            // 빌릴 회원의 password입력
            // 빌릴 회원의 입력받은 Id가 accountList의 길이만큼 돌면서 리스트에 있는값과 동일하다면 해당 Id를
            // 리턴해서 searchedAccount에 저장
            printBookListInfo();
            final int bookIdForBorrow = inputBookIdNumberForBorrow();
            final String accountId = inputMemberId();
            final String password = inputMemberPassword();
            final Account searchedAccount = findByAccountId(accountId);

            // 빌리고 싶은 책의id에서 stockCount를 받아서 0이면 false를 return
            // 빌릴수 없다고 출력
            if (!canBorrowBook(bookIdForBorrow)) {
                System.out.println("선택한 책은 더 이상 빌릴 수 없습니다! (다시 선택해주세요)");
                reDoProcess = true;
                continue;
            }

            // 회원 id로 정보 조회
            // 위에서 값을 return받지못해 null값이라면 다시 입력
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

            // 빌릴 책과 account의 id를 받고 빌린책은 카운트 -1을 실행한다
            final BorrowBook borrowBook =
                    new BorrowBook(bookIdForBorrow, searchedAccount.getId());
            borrowBookList.add(borrowBook);
            final Book book = bookList.get(bookIdForBorrow);
            book.subtractStockCount();

            reDoProcess = checkWantToMoreBorrow();
        } while (reDoProcess);
    }

    private boolean canBorrowBook(int bookIdForBorrow) {
        final Book book = bookList.get(bookIdForBorrow);
        final int stockCount = book.getStockCount();

        if (stockCount == 0) { return false; }

        return true;
    }


    // 책을 빌리고 나서 추가로 빌릴것인지를 체크하는 구문 y를 누르면 reDoProcess가 true가 되어 한번 더 돌아간다
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