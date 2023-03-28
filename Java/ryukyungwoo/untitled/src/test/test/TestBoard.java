package test.test;

class Board {
    final private int boardNumber;
    final private String boardName;
    final private String writer;
    final private String detail;

    public Board(int boardNumber, String boardName, String writer, String detail) {
        this.boardNumber = boardNumber;
        this.boardName = boardName;
        this.writer = writer;
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Board{" +
                "boardNumber=" + boardNumber +
                ", boardName='" + boardName + '\'' +
                ", writer='" + writer + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}
public class TestBoard {
    public static void main(String[] args) {
        Board board = new Board(1, "자유게시판", "유경우", "만세");
        System.out.println(board);
    }
}