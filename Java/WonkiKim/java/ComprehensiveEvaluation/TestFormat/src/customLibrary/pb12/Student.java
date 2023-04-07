package customLibrary.pb12;

import customLibrary.math.RandomGenerator;

public class Student implements Comparable<Student> {
    //12, 13번 문제 전부 작성했습니다.
    final private int score;

    public Student() {
        RandomGenerator randomGenerator = new RandomGenerator();
        this.score = randomGenerator.randomInt(0, 100);
    }

    public int getScore() {
        return this.score;
    }

    @Override
    public int compareTo(Student o) {
        return this.score - o.score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "score=" + score +
                '}' + "\n";
    }
}
