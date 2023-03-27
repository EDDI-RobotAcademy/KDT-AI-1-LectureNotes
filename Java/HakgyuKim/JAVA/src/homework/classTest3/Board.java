package homework.classTest3;

public class Board {
    final private int boardNum;
    final private String boardName;
    final private String boardWriter;

    public Board(int boardNum, String boardName, String boardWriter) {
        this.boardNum = boardNum;
        this.boardName = boardName;
        this.boardWriter = boardWriter;
    }

    @Override
    public String toString() {
        return "Board{" +
                "boardNum=" + boardNum +
                ", boardName='" + boardName + '\'' +
                ", boardWriter='" + boardWriter + '\'' +
                '}';
    }
}
