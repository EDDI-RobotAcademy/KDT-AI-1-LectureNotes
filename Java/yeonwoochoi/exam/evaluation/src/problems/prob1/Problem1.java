package problems.prob1;

// 학생 클래스를 만들어봅시다. 학생은 나이, 이름, 전공을 가지고 있습니다.

class Student {
    int age;
    String name;
    String major;

    public Student(int age, String name, String major) {
        this.age = age;
        this.name = name;
        this.major = major;
    }

    @Override
    public java.lang.String toString() {
        return "Student{" +
                "age=" + age +
                ", name=" + name +
                ", major=" + major +
                '}';
    }
}
public class Problem1 {
    public static void main(String[] args) {
       // Student student = new Student(20, "이름", "전공");
        //System.out.println(student);
    }
}
