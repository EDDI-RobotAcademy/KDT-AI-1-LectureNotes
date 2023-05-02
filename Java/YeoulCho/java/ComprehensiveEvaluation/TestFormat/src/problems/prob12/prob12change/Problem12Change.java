package problems.prob12.prob12change;

import customLibrary.classRoom.ClassRoom;

public class Problem12Change {
    public static void main(String[] args) { // 우선 뼈대를 만들고 그에 따라 클래스 생성
        final int CLASSROOM_STUDENT_NUMBER = 20;
        final ClassRoom classRoom = new ClassRoom(CLASSROOM_STUDENT_NUMBER);
        classRoom.evalauteStudent();
        System.out.println("반 평균: " + classRoom.getAverage());

        // 석차 출력(이름 생략)
        classRoom.printRank();
    }
}
