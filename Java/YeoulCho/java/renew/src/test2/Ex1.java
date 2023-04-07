package test2;

import java.util.Scanner;

public class Ex1 {//스위치문을 사용해서 일요일 = 0, ~~~~ 토요일 = 6, 숫자에 해당하는 요일 출력하시오

    public static void main(String[] args) {

        System.out.println("0~6 사이의 숫자를 넣으시오");


        while(true) {
            findDay();
        }

    }

    private static void findDay() {
        final int sunday = 0;
        final int monday = 1;
        final int tuesday = 2;
        final int wednesday = 3;
        final int thursday = 4;
        final int friday = 5;
        final int saturday = 6;
        Scanner scan = new Scanner(System.in);

        int day = scan.nextInt();
        switch (day) {
            case sunday:
                System.out.println("일요일입니다.");
                break;
            case monday:
                System.out.println("월요일입니다.");
                break;
            case tuesday:
                System.out.println("화요일입니다.");
                break;
            case wednesday:
                System.out.println("수요일입니다.");
                break;
            case thursday:
                System.out.println("목요일입니다.");
                break;
            case friday:
                System.out.println("금요일입니다.");
                break;
            case saturday:
                System.out.println("토요일입니다.");
                break;
            default:
                System.out.println("잘못된 입력 값입니다.");
                break;
        }
    }
}