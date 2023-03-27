package homework.fourth;

class Student{

    String name;
    int age;
    String major;


    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setMajor(String major){
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
public class ClassQuiz3 {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("김철수");
        student.setAge(22);
        student.setMajor("컴퓨터공학");

        System.out.println(student);
    }
}
