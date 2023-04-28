package evaluation.prob16;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookLibrary {
    final private List<Account> accountList;//아이디 리스트
    final private List<Book> bookList;//책 리스트
    final private List<BorrowBook> borrowBookList;
    final private Scanner scanner;

    private void presetBookList() {// 책 리스트
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
    public void registerAccount() {
        System.out.print("회원 id를 입력하세요: ");
        final String accountId = scanner.nextLine();

        System.out.print("회원 비밀번호를 입력하세요: ");
        final String password = scanner.nextLine();

        final Account account = new Account(accountId, password);
        accountList.add(account);
    }

    public void borrowBook() {
        Boolean reDoProcess = false;

        do {
            printBookListInfo();
            final int bookIdForBorrow = inputBookIdNumberForBorrow();//빌리고 싶은 책 번호 입력
            final String accountId = inputMemberId(); //2개의 아이디중 빌릴 아이디 입력
            final String password = inputMemberPassword();// 비밀 번호 입력
            final Account searchedAccount = findByAccountId(accountId);//아이디 확인하는 메서드

            if (!canBorrowBook(bookIdForBorrow)) {
                System.out.println("선택한 책은 더 이상 빌릴 수 없습니다! (다시 선택해주세요)");
                reDoProcess = true;// 스톡 카운트가 0일때  빌릴 수 없다는 뜻
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
                reDoProcess = true; //입력 정보가 가입 할때 입력한 정보와 같은지 확임함
                continue;
            }

            final BorrowBook borrowBook =
                    new BorrowBook(bookIdForBorrow, searchedAccount.getId());
            borrowBookList.add(borrowBook); // 빌린 책을 id 정보에 추가합니다.
            final Book book = bookList.get(bookIdForBorrow);
            book.subtractStockCount();// 빌린 책의 카운트를 줄여줍니다.

            reDoProcess = checkWantToMoreBorrow();
        } while (reDoProcess);
    }

    private boolean canBorrowBook(int bookIdForBorrow) {
        final Book book = bookList.get(bookIdForBorrow);
        final int stockCount = book.getStockCount();// 책의 남은 갯수 가져오기

        if (stockCount == 0) { return false; }// 남은 책이 0이라면  false 리턴

        return true;
    }

    private Boolean checkWantToMoreBorrow () {
        Boolean wrongValue = true;// 책을 빌린 후 더 빌린 것인지 물어보는것
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
        System.out.println(bookList);// 책 리스트 출력
    }

    private Account findByAccountId(String accountId) {// 입력된 아이디가 맞는지 확인해 주는 메서드
        for (int i = 0; i < accountList.size(); i++) {
            final Account searchedAccount = accountList.get(i);//리스트의 i 번째를 가져와서 입력한 id와 동일한지 체크 합니다.
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

