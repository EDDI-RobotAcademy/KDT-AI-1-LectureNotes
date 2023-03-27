package homework.fourth;

import java.util.Scanner;

class Board{
    final int MAX_NUMBER = 3;
    String title;
    String writer;
    String detail;

    final String[] titleArray = new String[MAX_NUMBER];
    final String[] writerArray = new String[MAX_NUMBER];
    final String[] detailArray = new String[MAX_NUMBER];

    int count = 0;
    public Board(){
        for(int i=0; i<MAX_NUMBER; i++){
            Scanner sc = new Scanner(System.in);
            System.out.print("제목 입력 : ");
            this.title = sc.nextLine();
            System.out.print("작성자 입력 : ");
            this.writer = sc.nextLine();
            System.out.print("내용 입력 : ");
            this.detail = sc.nextLine();

            saveInfo();
        }
    }

    public void saveInfo(){
        titleArray[count] = title;
        writerArray[count] = writer;
        detailArray[count] = detail;

        count++;
    }



    public void print(){
        for(int i=0; i<MAX_NUMBER; i++){
            System.out.println("번호 : " + (i+1) + ", 제목 : " + titleArray[i] + ", 작성자 : " + writerArray[i]
            + ", 내용 : " + detailArray[i]);
        }
    }


}
public class ClassQuiz2 {

    public static void main(String[] args) {
        Board board = new Board();
        board.print();
    }
}
