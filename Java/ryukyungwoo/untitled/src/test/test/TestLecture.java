package test.test;

class Lecture {
    final private String lectureTitle;
    final private String teacherName;
    final private int cost;

    public Lecture(String lectureTitle, String teacherName, int cost) {
        this.lectureTitle = lectureTitle;
        this.teacherName = teacherName;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "lectureTitle='" + lectureTitle + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", cost=" + cost +
                '}';
    }
}
public class TestLecture {
    public static void main(String[] args) {
        Lecture lecture = new Lecture("자바", "유경우", 100);
        System.out.println(lecture);
    }
}