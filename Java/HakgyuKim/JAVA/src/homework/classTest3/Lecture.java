package homework.classTest3;

public class Lecture {

    final private String lectureName;
    final private String lectureTeacher;
    final private int lectureCost;

    public Lecture(String lectureName, String lectureTeacher, int lectureCost) {
        this.lectureName = lectureName;
        this.lectureTeacher = lectureTeacher;
        this.lectureCost = lectureCost;
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "lectureName='" + lectureName + '\'' +
                ", lectureTeacher='" + lectureTeacher + '\'' +
                ", lectureCost=" + lectureCost +
                '}';
    }
}
