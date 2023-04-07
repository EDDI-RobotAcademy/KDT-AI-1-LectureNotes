package test2.classPracticeYu;

public class Student {
    private String name;
    private int ID;
    private String grade;

    public Student(String name, int ID, String grade) {
        this.name = name;
        this.ID = ID;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", ID=" + ID +
                ", grade='" + grade + '\'' +
                '}';
    }
}
