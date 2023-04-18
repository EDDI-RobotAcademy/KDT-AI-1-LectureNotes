package examSolve.exam1.customLibrary.book;

import examSolve.exam1.customLibrary.book.entity.Account;
import examSolve.exam1.customLibrary.book.entity.BorrowBook;
import examSolve.exam1.customLibrary.book.entity.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookLibrary {
    final private List<Account> accountList;
    final private List<Book> bookList;
    final private List<BorrowBook> borrowBookList;

    Scanner scan;

    public BookLibrary() {
        accountList = new ArrayList<>();
        bookList = new ArrayList<>();
        borrowBookList = new ArrayList<>();

        presetBookList();

        scan = new Scanner(System.in);
    }
    // 임의의 책 생성
    public void presetBookList(){
        bookList.add(new Book("20대 공부해라",1));
        bookList.add(new Book("30대 공부해라",2));
        bookList.add(new Book("40대 공부해라",1));
    }

    // 회원가입
    // ID와 비밀번호를 입력받아 Account를 생성
    // 생성한 account를 리스트화
    public void registerAccount() {
        System.out.print("회원 id를 입력하세요: ");
        final String accountId = scan.nextLine();

        System.out.print("회원 비밀번호를 입력하세요: ");
        final String password = scan.nextLine();

        final Account account = new Account(accountId, password);
        accountList.add(account);
    }

    // 도서 대여
    public void borrowBook() {
        Boolean reDoProcess = false;

        do {
            printBookListInfo();
            // 빌리고 싶은 책 번호를 bookIdForBorrow에 대입
            final int bookIdForBorrow = inputBookIdNumberForBorrow();
            // 회원 번호와 비밀번호를 대입
            final String accountId = inputMemberId();
            final String password = inputMemberPassword();
            // 회원이 맞는지 확인
            final Account searchedAccount = findByAccountId(accountId);

            // 재고가 없으면
            if (!canBorrowBook(bookIdForBorrow)) {
                System.out.println("선택한 책은 더 이상 빌릴 수 없습니다! (다시 선택해주세요)");
                reDoProcess = true;
                continue;
            }

            // 재고가 있으면
            // 회원 id로 정보 조회
            // 회원 id가 없으면 잘못된 정보를 입력했다는 문구 출력 후
            // 다시 처음으로 돌아가서 빌릴 수 있는 도서 리스트를 출력
            System.out.println("searchedAccount: " + searchedAccount);
            if (searchedAccount == null) {
                System.out.println("잘못된 정보를 기입하였습니다! (다시 입력하세요)");
                reDoProcess = true;
                continue;
            }

            // 회원 id는 있지만 비밀번호가 틀린 경우
            // 잘못된 정보를 입력했다는 문구 출력 후
            // 다시 처음으로 돌아가서 빌릴 수 있는 도서 리스트 출력
            if (!searchedAccount.getPassword().equals(password)) {
                System.out.println("잘못된 정보를 기입하였습니다! (다시 입력하세요)");
                reDoProcess = true;
                continue;
            }

            final BorrowBook borrowBook =
                    new BorrowBook(bookIdForBorrow, searchedAccount.getId());
            borrowBookList.add(borrowBook);
            final Book book = bookList.get(bookIdForBorrow);
            book.subtractStockCount();

            // 추가로 대여할지?
            // true를 입력받으면 do 구문 처음으로
            // false를 입력받으면 반복문 종료
            reDoProcess = checkWantToMoreBorrow();
        } while (reDoProcess);
    }

    // 대여하고자 하는 도서의 id를 입력받기
    // 해당 id를 도서리스트에 넣어서 book 생성
    // book의 재고를 stockCount 변수에 대입
    // 재고가 없으면 false
    // 있으면 true 반환
    private boolean canBorrowBook(int bookIdForBorrow) {
        final Book book = bookList.get(bookIdForBorrow);
        final int stockCount = book.getStockCount();

        if (stockCount == 0) { return false; }

        return true;
    }

    // 1권 이상 빌릴지 ?
    private Boolean checkWantToMoreBorrow () {
        Boolean wrongValue = true;
        do {
            System.out.print("계속 빌리시겠습니까 (y / n) ? ");
            final String inputString = scan.nextLine();

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
        final String password = scan.nextLine();
        return password;
    }

    private String inputMemberId() {
        System.out.print("회원님의 id를 입력하세요: ");
        final String accountId = scan.nextLine();
        return accountId;
    }

    // 빌리고 싶은 책 번호 받기
    private int inputBookIdNumberForBorrow() {
        System.out.print("빌리고 싶은 책의 id 번호를 입력하세요: ");
        final int inputBookId = scan.nextInt();
        scan.nextLine();
        return inputBookId;
    }

    private void printBookListInfo() {
        System.out.println("현재 빌릴 수 있는 책 리스트를 출력합니다!");
        System.out.println(bookList);
    }

    // 입력받은 회원번호로 회원이 맞는지 확인
    // 회원수만큼 루프를 돌며
    // 회원리스트에 있는 회원들을 searchedAccount에 넣고
    // 해당 회원의 id를 가져와서 searchedAccountId에 넣는다.

    // id만 맞으면(비밀번호가 틀리면)
    // 그 회원의 id와 비밀번호를 출력함

    // id가 다르면
    // 회원 리스트를 출력하고, 입력한 id는 없다는 null이 출력됨
    private Account findByAccountId(String accountId) {
        for (int i = 0; i < accountList.size(); i++) {
            final Account searchedAccount = accountList.get(i);
            final String searchedAccountId = searchedAccount.getAccountId();
            System.out.println("searchedAccountId: " + searchedAccountId);

            // 입력한 id가 찾은 id와 동일하면 해당 계정(id와 비밀번호)을 반환
            if (searchedAccountId.equals(accountId)) {
                return searchedAccount;
            }
        }
        return null;
    }

}
