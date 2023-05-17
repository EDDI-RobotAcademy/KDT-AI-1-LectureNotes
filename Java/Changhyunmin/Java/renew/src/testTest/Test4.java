package testTest;

import java.util.Scanner;
class Grade{
    private int math;
    private int science;
    private int english;

    public Grade(int math, int science, int english) {
        this.math = math;
        this.science = science;
        this.english = english;
    }
    int average(){
        return (this.math + this.science + this.english)/3;
    }
}

public class Test4 {
    public static void main(String[] args) {
        System.out.println("<점수를 작성해주세요>");
        Scanner sc = new Scanner(System.in);
        System.out.print("수학->");
        int math = sc.nextInt();
        System.out.print("과학->");
        int science = sc.nextInt();
        System.out.print("영어->");
        int english = sc.nextInt();
        Grade me = new Grade(math, science, english);
        System.out.println("평균: " + me.average());
    }
}
