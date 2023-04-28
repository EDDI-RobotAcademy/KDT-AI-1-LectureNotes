package examSolve.exam1.pro12;

import examSolve.exam1.customLibrary.classroom.ClassRoom;

// 문제 12, 13번
public class Pro12 {
    public static void main(String[] args) {
        ClassRoom classroom = new ClassRoom(20);
        classroom.calculateAvgScore();
        System.out.println(classroom.getAvgScore());
        classroom.printRank();
    }
}
