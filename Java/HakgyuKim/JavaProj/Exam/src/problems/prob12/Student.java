package problems.prob12;

public class Student {
    final private String name;
    final private int testScore;

    public Student(String name, int testScore) {
        this.name = name;
        this.testScore = testScore;
    }

    public String getName() {
        return name;
    }

    public int getTestScore() {
        return testScore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", testScore=" + testScore +
                '}';
    }
}
