package homework.third;
import java.util.Scanner;

class Board{
    Scanner scanner=new Scanner(System.in);
    int boardNumber;
    String boardWriter;
    String boardName;
    String boardText;


    public Board(){
        this.boardNumber=scanner.nextInt();

        this.boardWriter=scanner.nextLine();
        this.boardName=scanner.nextLine();
        this.boardText=scanner.nextLine();


    }

    @Override
    public String toString() {
        return "Board{" +
                "게시판 번호" + boardNumber +
                ", 작성자='" + boardWriter + '\'' +
                ", 제목='" + boardName + '\'' +
                ", 내용='" + boardText + '\'' +
                '}';
    }
}

public class MemberBoard {
    public static void main(String[] args) {

        Board board =new Board();
        System.out.println(board);

}}
