package problems.prob1;

public class StudentInfo {
    final private String name;
    final private int age;
    final private String major;

    public StudentInfo(String name, int age, String major) {
        this.name = name;
        this.age = age;
        this.major = major;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", major='" + major + '\'' +
                '}';
    }
}
