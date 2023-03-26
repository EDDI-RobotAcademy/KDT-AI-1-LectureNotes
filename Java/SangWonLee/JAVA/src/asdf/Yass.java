//package asdf;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Yass {
//
//    private String name;
//    private List<Student> students;
//
//    public Yass(String name) {
//        this.name = name;
//        this.students = new ArrayList<>();
//
//
//    }
//    public void addStudent(Student st){
//        this.students.add(st);
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public List<Student> getStudents() {
//        return students;
//    }
//
//    public void setStudents(List<Student> students) {
//        this.students = students;
//    }
//
//}

import java.util.ArrayList;
import java.util.List;

public class Yass {


    private String name;
    private List<Student> students;

    public Yass(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student st) {
        this.students.add(st);
    }

    public static class Student {
        private String name;
        private int number;
        private int result;

        public String getName() {
            return name;
        }

        public int getNumber() {
            return number;
        }

        public int getResult() {
            return result;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public void setResult(int result) {
            this.result = result;
        }

        public Student(String name, int number, int result) {
            this.name = name;
            this.number = number;
            this.result = result;
        }
    }
}