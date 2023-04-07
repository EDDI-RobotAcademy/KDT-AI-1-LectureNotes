package problems.prob12;

import customLibrary.pb12.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem12 {
    public static void main(String[] args) {
        final int NUMBER_OF_STUDENTS = 20;
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_STUDENTS; i++) {
            studentList.add(new Student());
        }

        int sum = 0;
        for (Student student : studentList) {
            sum += student.getScore();
        }
        int average =(int) sum/NUMBER_OF_STUDENTS;
        System.out.println(average);

        Collections.sort(studentList, Collections.reverseOrder());
        for(Student student: studentList){
            System.out.println(student);
        }
    }
}
