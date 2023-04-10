package problems.prob1;

class Student {
   final private int age;
   final private String name;
   final private String major;
   public Student (int age, String name, String major) {
       this.age = age;
       this.name = name;
       this.major = major;
   }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", major='" + major + '\'' +
                '}';
    }
}
public class Problem1 {
    public static void main(String[] args) {
        Student student = new Student(100, "홍길동", "마술");
        System.out.println(student);

    }
}
