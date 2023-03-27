package homework.fourth.student;

public class Student {
    //필드
    private String name;
    private int age;
    private String major;

    //생성자
    public Student(){}
    public Student(String name, int age, String major){
        this.name = name;
        this.age = age;
        this.major = major;
    }

    //메서드
    public void showInfo(){
        System.out.println("이름은 "+name+", 나이는 "+age+", 전공은 "+major);
    }
}
