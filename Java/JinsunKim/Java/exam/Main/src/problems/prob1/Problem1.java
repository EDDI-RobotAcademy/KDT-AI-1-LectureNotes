package problems.prob1;


import customLibrary.Student;

//학생 클래스를 만들어봅시다. 학생은 나이, 이름, 전공을 가지고 있습니다.


public class Problem1 {
    public static void main(String[] args) {

        Student student = new Student("이름",30,"전공");
        System.out.println(student);
    }
}
