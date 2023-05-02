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
        // 3. Book 호출, Book 클래스로부터 객체 생성
        //    "20대 공부해라", 1, 0
        //    "30대 공부해라", 2, 1
        //    ...

        // 9. 만든 객체들을 bookList 리스트에 추가
    }
    public BookLibrary() {
        accountList = new ArrayList<>();
        bookList = new ArrayList<>();
        borrowBookList = new ArrayList<>();

        presetBookList();
        // 2. presetBookList 메서드 호출

        scanner = new Scanner(System.in);
    }
    public void registerAccount() {
        System.out.print("회원 id를 입력하세요: ");
        final String accountId = scanner.nextLine();

        System.out.print("회원 비밀번호를 입력하세요: ");
        final String password = scanner.nextLine();
        // 11. id와 비밀번호 입력 받기

        final Account account = new Account(accountId, password);
        // 12. 입력받은 id와 비밀번호를 매개변수로 하는 Account 클래스 객체 생성

        accountList.add(account);
        // 14. accountList 리스트에 account 객체 추가 { id값, id, password }
    }

    public void borrowBook() {
        Boolean reDoProcess = false;

        do {
            printBookListInfo();
            final int bookIdForBorrow = inputBookIdNumberForBorrow();
            // 16. book id값 입력받기

            final String accountId = inputMemberId();
            final String password = inputMemberPassword();
            // 17. 회원 id, password값 입력받기

            final Account searchedAccount = findByAccountId(accountId);
            // 18. findByAccountId 메서드 호출

            if (!canBorrowBook(bookIdForBorrow)) {
                System.out.println("선택한 책은 더 이상 빌릴 수 없습니다! (다시 선택해주세요)");
                reDoProcess = true;
                continue;
            }
            // 22. canBorrowBook에서 0을 return 했다면
            // reDoProcess가 true가 되어 다시 do 실행

            // 회원 id로 정보 조회
            System.out.println("searchedAccount: " + searchedAccount);
            if (searchedAccount == null) {
                System.out.println("잘못된 정보를 기입하였습니다! (다시 입력하세요)");
                reDoProcess = true;
                continue;
            }
            // 23. accountId가 accountList에 없으면 다시 do 실행

            if (!searchedAccount.getPassword().equals(password)) {
                System.out.println("잘못된 정보를 기입하였습니다! (다시 입력하세요)");
                reDoProcess = true;
                continue;
            }
            // 24. accountList 객체 내의 password와 입력된 password가 다르면
            // 다시 do 실행

            final BorrowBook borrowBook =
                    new BorrowBook(bookIdForBorrow, searchedAccount.getId());
            // 25. 빌리고자 하는 book id값과 등록된 사용자 id 값을 매개변수로
            //     BorrowBook 클래스 객체 생성

            borrowBookList.add(borrowBook);
            // 26. borrowBookList에 추가
            
            final Book book = bookList.get(bookIdForBorrow);
            // 27. bookList에서 빌린 책의 id값에 해당하는 객체 정보 호출

            book.subtractStockCount();
            // 28. 남은 수량 -1

            reDoProcess = checkWantToMoreBorrow();
            // 29. 더 빌릴지 물어보기

        } while (reDoProcess);
        // 30. 종료
    }

    private boolean canBorrowBook(int bookIdForBorrow) {
        final Book book = bookList.get(bookIdForBorrow);
        final int stockCount = book.getStockCount();

        if (stockCount == 0) { return false; }

        return true;
        // 21. 아마 나중에 사용된 값이 0(false)이 될 것 같음
        //     -> 남은 개수를 관리하는 변수였음. 0이 되어 빌릴 수 없는 상태가 되면 다시 do 실행
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
        for (int i = 0; i < accountList.size(); i++) {
            final Account searchedAccount = accountList.get(i);
            final String searchedAccountId = searchedAccount.getAccountId();
            // 19. 입력받은 회원 id로 accountId 가져오기
            System.out.println("searchedAccountId: " + searchedAccountId);

            if (searchedAccountId.equals(accountId)) {
                return searchedAccount;
            }
            // 20. accountId와 serchedAccountId 값 비교
            // 같으면 해당하는 Account 객체 정보 return
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
