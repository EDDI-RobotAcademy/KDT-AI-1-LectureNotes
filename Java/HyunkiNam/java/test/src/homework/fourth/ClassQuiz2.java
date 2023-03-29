package homework.fourth;

import java.util.Scanner;

class Board{
    final int MAX_NUMBER = 3;
    String title;
    String writer;
    String detail;

    public Board(){
        Scanner sc = new Scanner(System.in);
        System.out.print("제목 입력 : ");
        this.title = sc.nextLine();
        System.out.print("작성자 입력 : ");
        this.writer = sc.nextLine();
        System.out.print("내용 입력 : ");
        this.detail = sc.nextLine();
    }
    
    public void print(){
            System.out.println("번호 : " + ", 제목 : " + title + ", 작성자 : " + writer
            + ", 내용 : " + detail);
    }
}

public class ClassQuiz2 {

    public static void main(String[] args) {
        Board[] boards = new Board[3];
        for(int i=0; i< boards.length; i++){
            boards[i] = new Board();
        }
        for(int i=0; i< boards.length;i++){
            boards[i].print();
        }
    }
}
