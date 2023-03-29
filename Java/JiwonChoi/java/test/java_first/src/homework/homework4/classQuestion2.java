package homework4;
import java.util.Scanner;

/*
2. Board(게시판) 클래스를 만들어봅시다.
게시판 번호, 제목, 작성자, 내용을 표현해주세요.
마찬가지로 Scanner 사용해도 되고 하지 않아도 됩니다.
 */

class Board {
	int boardNumber;
	String boardTitle;
	String boardWriter;
	String boardContents;
	
	Board(int boardNumber, String boardTitle, String boardWriter){
		this.boardNumber = boardNumber;
		this.boardTitle = boardTitle;
		this.boardWriter = boardWriter;
	}

	
	public String getBoardContents() {
		return boardContents;
	}
	public void setBoardContents(String boardContents) {
		this.boardContents = boardContents;
	}	
}


public class classQuestion2 {
	public static void main(String[] args) {
		//작성자, 제목, 내용 입력받기
		Scanner scan1 = new Scanner(System.in);
		System.out.println("작성자명을 입력하세요: ");
		String boardWriter = scan1.next();
		
		Scanner scan2 = new Scanner(System.in);
		System.out.println("게시물 제목을 입력하세요: ");
		String boardTitle = scan2.next();
		
		Scanner scan3 = new Scanner(System.in);
		System.out.println("게시물 내용을 입력하세요: ");
		String BoardContents = scan3.next();
		
		
		//board1 생성하고 게시판 번호 지정, 입력받은 제목, 작성자 지정
		Board board1 = new Board(1, boardTitle, boardWriter);
		//입력 받은 내용을 지정
		board1.setBoardContents(BoardContents);
		
		//지정된 board1을 출력
		System.out.println("작성자 : " + board1.boardWriter);
		System.out.println(board1.boardTitle);
		System.out.println(board1.getBoardContents());
	}

}
