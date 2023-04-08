package problems.prob12;

public class Problem12 {
    public static void main(String[] args) {
        // problem 12. 학생들의 평균 점수 구하기
        StudentManager studentManager = new StudentManager();
        studentManager.getStudentTestScoreAvr();

        // problem 13. 학생들 점수 정렬 순위 표시
        studentManager.getStudentTestScoreRank();
    }
}
