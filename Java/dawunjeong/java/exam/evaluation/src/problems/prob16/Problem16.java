package problems.prob16;

// 문제 16번부터 19번입니다.
public class Problem16 {
    public static void main(String[] args) {
        BookRentalManager manager = new BookRentalManager();
        // 3명이 회원가입을 하고 회원 정보를 출력
        System.out.println("사용할 이메일과 비밀번호를 입력하세요.");
        manager.addMember();
        System.out.println("사용할 이메일과 비밀번호를 입력하세요.");
        manager.addMember();
        System.out.println("사용할 이메일과 비밀번호를 입력하세요.");
        manager.addMember();
        manager.printMemberList();
        System.out.println();

        // 랜덤한 책을 생성해서 리스트에 넣기
        manager.addRandomBook();
        manager.printBookList();
        System.out.println();

        // 랜덤한 책을 랜덤한 회원이 대여
        manager.rentalRandomBook();
        System.out.println("대여자 목록");
        manager.printBookList();
    }
}
