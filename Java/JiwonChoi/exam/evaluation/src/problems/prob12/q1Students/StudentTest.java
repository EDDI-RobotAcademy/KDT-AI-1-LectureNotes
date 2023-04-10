package problems.prob12.q1Students;

public class StudentTest {
    public static void main(String[] args) {
        Students class1 = new Students();
        class1.AverageGrade();
        class1.Rank();

        System.out.println("점수 순위대로 정렬");
        class1.LineUpRank();
    }
}
