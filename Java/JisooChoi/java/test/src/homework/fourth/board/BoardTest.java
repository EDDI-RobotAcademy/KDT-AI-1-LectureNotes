package homework.fourth.board;

import java.util.Scanner;

public class BoardTest {
    public static void main(String[] args) {
        Board board1 = new Board(1, "복습하는 방법", "최지수", "지난 내용을 정리하고, 문제 풀이를 통해 학습한다.");
        board1.showInfo();

        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();
        scan.nextLine();
        String title = scan.nextLine();
        String writer = scan.nextLine();
        String content = scan.nextLine();

        Board board2 = new Board(num, title, writer, content);

        board2.showInfo();
    }
}
