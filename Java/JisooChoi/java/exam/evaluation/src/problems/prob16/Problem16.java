package problems.prob16;

import customLibrary.prob16.Book;
import customLibrary.prob16.User;

import java.util.*;

class library{
    HashMap<String, User> users = new HashMap<>();
    ArrayList<Book> bookList = new ArrayList<>();

    public library() {
        // 기존 도서관에 있는 책들
        String[] bookName = {"신데렐라", "백설공주", "오즈의 마법사"};

        for(int i = 0; i < bookName.length; i++){
            bookList.add(new Book(bookName[i]));
        }
    }

    public void signUp() {
        try{
            Scanner scan = new Scanner(System.in);

            User user = new User();
            System.out.printf("아이디를 입력해주세요 : ");
            user.setLibraryId(scan.nextLine());
            System.out.printf("비밀번호를 입력해주세요(only num) : ");
            user.setLibraryPw(scan.nextInt());

            // 회원 가입
            users.put(user.getLibraryId(), user);
            System.out.printf("%s님 도서관 회원가입을 축하드립니다 !\n", user.getLibraryId());

        } catch (InputMismatchException e){
            System.out.println("\n올바른 입력을 다시 넣어주세요 > ");
            signUp();
        }
    }

    public void bookManagementList(String[] bookAddName){
        for (int i = 0; i < bookAddName.length; i++) {
            bookList.add(new Book(bookAddName[i]));
        }
    }

    public User login() {
        System.out.println("\n※ 로그인을 해야 책을 빌릴 수 있습니다.");
        Scanner scan = new Scanner(System.in);

        User user = null;
        try{
            System.out.printf("아이디: ");
            String loginId = scan.nextLine();

            System.out.printf("비밀번호: ");
            int loginPw = scan.nextInt();

            // 아이디가 존재하는지 확인
            user = users.get(loginId);
            if(user == null){
                throw new NoSuchElementException();
            }

            // 비밀번호가 존재하는지 확인
            if(loginPw != user.getLibraryPw()){
                throw new NoSuchElementException();
            }

            System.out.println("로그인 성공 !");
        } catch (NoSuchElementException e){
            System.out.printf("올바른 입력을 다시 넣어주세요.\n");
            login();
        }
        return user;
    }

    // 책 대출 -> ★ 미흡 (다시 생각해보기)
    public void bookCheckOut(User user, Book book) {
        if(book.isAvailable() == true){
            user.getCheckOutBook().add(book);
            book.setAvailable(false);

            System.out.println();
            System.out.println(book.getBookName()+" 책을 대출하였습니다.");
        }

        System.out.println();
        System.out.println(book.getBookName()+" 책은 현재 대출 중 입니다.\n");
    }

    public void availableBookInfo() {
        System.out.println("===== 대출 가능한 목록 =====");
        for(int i = 0; i < bookList.size(); i++){
            if(bookList.get(i).isAvailable() == true){
                System.out.println(bookList.get(i).getBookName());
            }
        }
    }

}

public class Problem16 {
    public static void main(String[] args) {
        library library = new library();

        // 1
        System.out.println("회원가입을 시작합니다.");
        library.signUp();

        // 2
        System.out.println("\n ========= 도서관 책 현황 =========");
        System.out.println(library.bookList);

        String[] addBookName = {"인간실격", "데미안", "동물농장"};
        library.bookManagementList(addBookName);

        System.out.println("\n ====== 도서관 책 추가 후 현황 ======");
        System.out.println(library.bookList);

        // 3 + 4
        User loginUser = library.login();

        // 책을 고른다.
        int bookPosition = (int)(Math.random() * library.bookList.size()-1) + 1;
        Book selectedBook = library.bookList.get(bookPosition);

        // 책을 빌린다.
        library.bookCheckOut(loginUser, selectedBook);

        // 대출이 가능한 책만 보여주기
        library.availableBookInfo();
    }
}
