package problems.prob1;

class Student {
    final private int AGE;
    final private String NAME;
    final private String MAJOR;

    public Student() {
        this.AGE = 1;
        this.NAME = "김형진";
        this.MAJOR = "전공학과";
    }

    public int getAGE() {
        return AGE;
    }

    public String getNAME() {
        return NAME;
    }

    public String getMAJOR() {
        return MAJOR;
    }
}

public class Problem1 {
    public static void main(String[] args) {
        final Student student = new Student();

        System.out.println("나이: " + student.getAGE() + "세");
        System.out.println("이름: " + student.getNAME());
        System.out.println("전공: " + student.getMAJOR());
    }
}

// 1. 학생 클래스를 만들어봅시다. 학생은 나이, 이름, 전공을 가지고 있습니다.