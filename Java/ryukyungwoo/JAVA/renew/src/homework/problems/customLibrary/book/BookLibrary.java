package homework.problems.customLibrary.book;

public class BookLibrary {
    final private List<Account> accountList;            // 계정 목록
    final private List<Book> bookList;                  // 책 목록
    final private List<BorrowBook> borrowBookList;      // 빌린 책 목록
    final private Scanner scanner;                      // 키보드 입력

    private void presetBookList() {                                     // 책 목록에 미리 책 넣어두기
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
    public void registerAccount() {                                 // 계정 등록을 위한 매서드
        System.out.print("회원 id를 입력하세요: ");
        final String accountId = scanner.nextLine();

        System.out.print("회원 비밀번호를 입력하세요: ");
        final String password = scanner.nextLine();

        final Account account = new Account(accountId, password);
        accountList.add(account);
    }

    public void borrowBook() {                                                          //책 빌리기를 위한 매서드
        Boolean reDoProcess = false;

        do {
            printBookListInfo();
            final int bookIdForBorrow = inputBookIdNumberForBorrow();
            final String accountId = inputMemberId();
            final String password = inputMemberPassword();
            final Account searchedAccount = findByAccountId(accountId);

            if (!canBorrowBook(bookIdForBorrow)) {
                System.out.println("선택한 책은 더 이상 빌릴 수 없습니다! (다시 선택해주세요)");
                reDoProcess = true;
                continue;
            }

            // 회원 id로 정보 조회
            System.out.println("searchedAccount: " + searchedAccount);              // 계정을 찾는 매서드
            if (searchedAccount == null) {
                System.out.println("잘못된 정보를 기입하였습니다! (다시 입력하세요)");
                reDoProcess = true;
                continue;
            }

            if (!searchedAccount.getPassword().equals(password)) {                   // 비밀번호를 확인하는 매서드
                System.out.println("잘못된 정보를 기입하였습니다! (다시 입력하세요)");
                reDoProcess = true;
                continue;
            }

            final BorrowBook borrowBook =
                    new BorrowBook(bookIdForBorrow, searchedAccount.getId());
            borrowBookList.add(borrowBook);                                     // 책을 빌리면 빌린 책 리스트에 책을 등록
            final Book book = bookList.get(bookIdForBorrow);
            book.subtractStockCount();

            reDoProcess = checkWantToMoreBorrow();
        } while (reDoProcess);
    }

    private boolean canBorrowBook(int bookIdForBorrow) {                        // 책의 남은 권수로 빌릴 수 있는지 판별하는 매서드
        final Book book = bookList.get(bookIdForBorrow);                        // 리스트에서 책의 Id로 검색
        final int stockCount = book.getStockCount();                            // 남은 권수

        if (stockCount == 0) { return false; }                                  // 남은게 없다 면 false

        return true;                                                            // 없다면 true
    }

    private Boolean checkWantToMoreBorrow () {                                   // 책을 더 빌리고 싶은지 의사를 묻는 매서드
        Boolean wrongValue = true;
        do {
            System.out.print("계속 빌리시겠습니까 (y / n) ? ");                      // do-while문으로
            final String inputString = scanner.nextLine();                       //  no가 나올때까지 반복
            //  no가 나오면 return값을 false로
            if (inputString.equals("y")) {
                return true;
            }
            if (inputString.equals("n")) {
                return false;
            }
        } while (wrongValue);

        return false;
    }

    private String inputMemberPassword() {                                      // 비밀번호 입력을 받는 매서드
        System.out.print("회원님의 비밀번호를 입력하세요: ");
        final String password = scanner.nextLine();                             // 스캐너로 받아서
        return password;                                                        // 패스워드로 나옴
    }

    private String inputMemberId() {                                            // Id 입력을 받는 매서드
        System.out.print("회원님의 id를 입력하세요: ");
        final String accountId = scanner.nextLine();                            // 스캐너로 받아서
        return accountId;                                                       // 계정 아이디로 나옴
    }

    private int inputBookIdNumberForBorrow() {                                  // 책의 Id 입력을 받는 매서드
        System.out.print("빌리고 싶은 책의 id 번호를 입력하세요: ");
        final int inputBookId = scanner.nextInt();                              // 스캐너로 받아서
        scanner.nextLine();
        return inputBookId;                                                     // Id로 나옴
    }

    private void printBookListInfo() {                                          // 책 정보를 출력하는 매서드
        System.out.println("현재 빌릴 수 있는 책 리스트를 출력합니다!");
        System.out.println(bookList);                                           // 책 리스트를 출력
    }

    private Account findByAccountId(String accountId) {                         // 계정을 찾기 위한 매서드
        for (int i = 0; i < accountList.size(); i++) {
            final Account searchedAccount = accountList.get(i);                 // 계정 리스트의 size만큼 다 불러옴
            final String searchedAccountId = searchedAccount.getAccountId();    //
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