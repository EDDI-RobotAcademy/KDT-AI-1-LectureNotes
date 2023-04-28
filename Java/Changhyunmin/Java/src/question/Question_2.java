package question;

import java.util.Scanner;

class Board {
    Scanner sc = new Scanner(System.in);
    final private int BoardNumber;
    final private String BoardName;
    final private String User;
    final private String detail;

    public Board() {
        System.out.print("게시판번호: ");
        BoardNumber = sc.nextInt();
        System.out.print("게시판제목: ");
        BoardName = sc.next();
        System.out.print("작성자: ");
        User = sc.next();
        System.out.println("내용: ");
        detail = sc.next();
    }

    @Override
    public String toString() {
        return BoardNumber +". "
               + BoardName  + '\n'+ "작성자: "
                + User + '\n'
                + "내용: " + detail;
    }
}
public class Question_2 {
    public static void main(String[] args) {
        Board board = new Board();
        System.out.println(board);
    }
}
