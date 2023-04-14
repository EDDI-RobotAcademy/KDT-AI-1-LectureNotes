package examPractice.classRoom;
// 12. 반 학생 수 20명 점수 생성
// 평균 계산 프로그램 작성
// 13. 점수 정렬하여 순위 출력
public class Prob12 {
    public static void main(String[] args) {
        final int MAX_STUDENT_NUMBER = 3;

        final ClassRoom classRoom = new ClassRoom(MAX_STUDENT_NUMBER);
        classRoom.evaluateStudent();
        classRoom.printRank();

    }
}
