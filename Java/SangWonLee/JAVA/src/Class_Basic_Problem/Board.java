package Class_Basic_Problem;

import java.awt.*;
import java.util.Scanner;

public class Board {
    private int board_Number; // 게시판 번호
    private String board_Title; // 게시판 제목
    private String board_Writer; // 게시판 작성자
    private String board_Content; // 게시판 내용

    boolean abc = true; // Board에서 while 탈출 조건
    Scanner sc = new Scanner(System.in);

    public Board() {

        while (abc) {

            board_Number = (int) (Math.random() * 10 + 1); // 게시판 번호 랜덤 숫자 부여



            System.out.print("게시판 제목를 입력해주세요. → ");
            board_Title = sc.nextLine();


            System.out.print("게시판 작성자를 입력해주세요. → ");
            board_Writer = sc.nextLine();

            System.out.print("게시판 내용을 입력해주세요. → ");
            board_Content = sc.nextLine();

            System.out.println("게시판 번호 : " + board_Number + "\n" + "게시판 제목 : " + board_Title + "\n" + "게시판 작성자 : " +
                    board_Writer + "\n" + "게시판 내용 : " + board_Content + "\n");


            end_Board();
            sc.nextLine();
        }
    }

    public void end_Board() {

        boolean replay = true; // end_Board에 while 탈출 조건
        int replay_Number; // 계속 할지 말지 번호 입력

        while (replay) {
            System.out.println("계속 하시겠습니까? 1) 계속    2) 종료  ");
            replay_Number = sc.nextInt();

            switch (replay_Number) {
                case 1:
                    System.out.println(" 계속합니다..");
                    replay = false; // 여기 있는 while문 탈출
                    break; // 스위치문 탈출
                case 2:
                    abc = false; // Board에 있는 while문 탈출
                    replay = false; // 여기 있는 while문 탈출
                    break; // 스위치문 탈출
                default:
                    System.out.println("다시 입력하세요.");

            }
        }
    }



    public static void main(String[] args) {


        Board b = new Board();

        System.out.println(b);
    }
}

