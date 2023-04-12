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
    final List<BorrowBook> borrowBookList;
    final private Scanner scanner;

    //17번 문제 임의 책 3권 넣기
    private void presetBookList(){
        bookList.add(new Book("20대 공부해라", 1));
        bookList.add(new Book("30대 공부해라", 2));
        bookList.add(new Book("40대 공부해라", 1));
    }

    //생성자
    public BookLibrary() {
        accountList = new ArrayList<>();
        bookList = new ArrayList<>();
        borrowBookList = new ArrayList<>();
        presetBookList();
        scanner = new Scanner(System.in);
    }
    //16번 회원가입 만들기
    public void registerAccount(){
        System.out.print("회원 id를 입력하세요");
        final String accountId = scanner.nextLine();
        System.out.print("회원 비밀번호를 입력하세요");
        final String password = scanner.nextLine();

        //위에서 입력받은 회원 id와 비밀번호로 Account 클래스 생성하면서 매개변수로 넣어줌
        final Account account = new Account(accountId, password);
        accountList.add(account);
    }
    //책 대출메서드
    public void borrowBook(){
        boolean reDoProcess = false;
        do{
            printBookList();//빌릴 수 있는 책목록 확인
            // 빌리고 싶은 책의 id를 받아온다.
            final int bookIdForBorrow = inputBookIdNumberForBorrow();

            // 회원 id를 받아온다.
            final String accountId = inputMemberId();
            // 회원 비밀번호를 받아온다.
            final String password = inputMemberPassword();

            // 회원 id가 존재하는 지 확인한다.
            final Account searchedAccount = findByAccountId(accountId);

            // 책이 없다면
            if (!canBorrowBook(bookIdForBorrow)) {
                System.out.println("선택한 책은 더 이상 빌릴 수 없습니다! (다시 선택해주세요)\n");
                reDoProcess = true;
                continue;
            }final int bookId;

            // 회원 id로 정보 조회
            System.out.println("searchedAccount: " + searchedAccount);
            if (searchedAccount == null) {
                System.out.println("잘못된 정보를 기입하였습니다! (다시 입력하세요)");
                reDoProcess = true;
                continue; //for문 다시 돌아가라
            }

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

            reDoProcess = checkWantToMoreBorrow();
        } while (reDoProcess);
    }



    //대여하고자 하는 id입력
    private boolean canBorrowBook(int bookIdForBorrow) {
        final Book book = bookList.get(bookIdForBorrow);
        final int stockCount = book.getStockCount();

        if (stockCount == 0) { return false; }// 재고가 없으면 false
        return true;// 재고 있으면 true 반환
    }
    // 몇권 빌릴지 확인하는 메서드
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
        } while (wrongValue); //y 누르면 계속빌리게해

        return false;
    }

    private Account findByAccountId(String accountId){ // 입력한 accountId가 회원이 맞는지 찾아보자
        for(int i =0; i<accountList.size();i++){
            final Account searchedAccount = accountList.get(i); //회원만큼 루프를 돌며 searchedAccount에 회원리스트 회원을 넣어
            final String searchedAccountId = searchedAccount.getAccountId(); //searchedAccount의 회원아이디를 넣어
            System.out.println("searchedAccountId: " + searchedAccountId);
            if(searchedAccountId.equals(accountId)){
                return searchedAccount; // 입력한 id가 찾은 id와 동일하면 해당 계정(id와 비밀번호)을 반환
            }
        }
        return null;
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

    private void printBookList() {
        System.out.println("\n현재 빌릴 수 있는 책 리스트를 출력합니다!");
        System.out.println(bookList);
    }

    @Override
    public String toString() {
        return "BookLibrary{" +
                "accountList=" + accountList +
                ", bookList=" + bookList + "\n"+
                ", borrowBookList=" + borrowBookList +"\n"+
                '}';
    }
}
