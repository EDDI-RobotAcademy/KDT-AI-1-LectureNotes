package asdf;

import java.util.ArrayList;
import java.util.List;

public class Student {
    class student {

        private String name; // 학생 이름
        private int number; // 학생 번호
        private int result; // 학생 성적

        public student(String name, int number, int result) { // 생성자
            this.name = name;
            this.number = number;
            this.result = result;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public int getResult() {
            return result;
        }

        public void setResult(int result) {
            this.result = result;
        }
    }

    static class yass {

        private String name;
        private List<student> students;

        public yass(String name) {
            this.name = name;
            this.students = new ArrayList<>();


        }

        public void addStudent(student st) {
            this.students.add(st);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<student> getStudents() {
            return students;
        }

        public void setStudents(List<student> students) {
            this.students = students;
        }

    }

}