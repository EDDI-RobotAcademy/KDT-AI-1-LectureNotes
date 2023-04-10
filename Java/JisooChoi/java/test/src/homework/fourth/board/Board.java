package homework.fourth.board;

public class Board {
    //필드
    private int boardNum;
    private String title;
    private String writer;
    private String content;

    //생성자
    public Board(){

    }

    public Board(int boardNum, String title, String writer, String content){
        this.boardNum = boardNum;
        this.title = title;
        this.writer = writer;
        this.content = content;
    }

    //메서드
    public void showInfo(){
        System.out.println("------ 게시판 작성 ------");
        System.out.println("게시판 "+boardNum+"번");
        System.out.println("제목: "+title);
        System.out.println("작성자: "+writer);
        System.out.println("내용: "+content);
    }
}
