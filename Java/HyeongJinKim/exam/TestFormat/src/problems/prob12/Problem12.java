package problems.prob12;

import customLibrary.classroom.ClassRoom;

public class Problem12 {
    public static void main(String[] args) {
        // 12 ~ 13번 모두 완료
        final int CLASSROOM_STUDENT_NUMBER = 20;
        final ClassRoom classRoom = new ClassRoom(CLASSROOM_STUDENT_NUMBER);
        classRoom.evalauteStudent();
        System.out.println("반 평균: " + classRoom.getMean());

        // 석차 출력(이름 생략)
        classRoom.printRank();
    }
}
