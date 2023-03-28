package homework.classPractice;

import java.util.Scanner;

class BoardManagement {
    final private String boardWriter;
    final private String boardDetail;
    private int boardNumber = 0;
    final private Scanner scan = new Scanner(System.in);
    public BoardManagement() {
        System.out.print("작성자 이름을 입력해주세요: ");
        this.boardWriter = scan.nextLine();
        System.out.print("내용을 입력해주세요: ");
        this.boardDetail = scan.nextLine();
        boardNumber++;
    }
    public BoardInfo toBoardInfo() {
        return new BoardInfo(boardWriter, boardDetail, boardNumber);
    }
}

class BoardInfo {
    final private String boardWriter;
    final private String boardDetail;
    private int boardNumber = 0;

    public BoardInfo(String boardWriter, String boardDetail, int boardNumber) {
        this.boardWriter = boardWriter;
        this.boardDetail = boardDetail;
        this.boardNumber = boardNumber;
    }

    @Override
    public String toString() {
        return "BoardInfo{" +
                "boardWriter='" + boardWriter + '\'' +
                ", boardDetail='" + boardDetail + '\'' +
                ", boardNumber=" + boardNumber +
                '}';
    }
}
public class Board {
    public static void main(String[] args) {
        BoardManagement boardManagement = new BoardManagement();
        BoardInfo boardInfo = boardManagement.toBoardInfo();
        System.out.println(boardInfo);
    }
}
