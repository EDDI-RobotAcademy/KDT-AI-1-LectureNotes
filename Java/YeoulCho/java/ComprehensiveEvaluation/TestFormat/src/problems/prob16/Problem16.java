package problems.prob16;
//16. 도서관 회원 가입이 가능하도록 프로그램을 작성해주세요.
//17. 임의의 책 3권을 도서 관리 목록에 추가해주세요.
//18. 가입된 회원들이 도서를 빌릴 수 있도록 만들어주세요.
//19. 도서에 수량 개념을 도입하여 기존 기능들이 동작하도록 만들어주세요.
//재고가 부족한 경우 도서를 빌리지 못하게 만들어주세요.

import customLibrary.book.BookLibrary;

public class Problem16 {
    public static void main(String[] args) {
            // 16 ~ 17번 답안보고 풀어보기
            // todo:18~19번 좀더 확실하게 이해하기
            final BookLibrary bookLibrary = new BookLibrary(); //도서관 객체 생성
            bookLibrary.registerAccount(); // 도서관에 회원가입
            bookLibrary.registerAccount(); // 도서관에 회원가입2

            System.out.println(bookLibrary); //두명이 도서관에 가입했는지 확인
            bookLibrary.borrowBook(); //도서관에서 책을 대출
            System.out.println(bookLibrary); //확인
        }

    }

