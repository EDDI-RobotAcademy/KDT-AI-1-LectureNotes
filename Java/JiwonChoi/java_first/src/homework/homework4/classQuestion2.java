package homework4;
import java.util.Scanner;

/*
2. Board(�Խ���) Ŭ������ �����ô�.
�Խ��� ��ȣ, ����, �ۼ���, ������ ǥ�����ּ���.
���������� Scanner ����ص� �ǰ� ���� �ʾƵ� �˴ϴ�.
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
		//�ۼ���, ����, ���� �Է¹ޱ�
		Scanner scan1 = new Scanner(System.in);
		System.out.println("�ۼ��ڸ��� �Է��ϼ���: ");
		String boardWriter = scan1.next();
		
		Scanner scan2 = new Scanner(System.in);
		System.out.println("�Խù� ������ �Է��ϼ���: ");
		String boardTitle = scan2.next();
		
		Scanner scan3 = new Scanner(System.in);
		System.out.println("�Խù� ������ �Է��ϼ���: ");
		String BoardContents = scan3.next();
		
		
		//board1 �����ϰ� �Խ��� ��ȣ ����, �Է¹��� ����, �ۼ��� ����
		Board board1 = new Board(1, boardTitle, boardWriter);
		//�Է� ���� ������ ����
		board1.setBoardContents(BoardContents);
		
		//������ board1�� ���
		System.out.println("�ۼ��� : " + board1.boardWriter);
		System.out.println(board1.boardTitle);
		System.out.println(board1.getBoardContents());
	}

}
