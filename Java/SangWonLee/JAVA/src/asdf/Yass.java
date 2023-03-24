package asdf;

import java.util.ArrayList;
import java.util.List;

public class Yass {

    private String name;
    private List<Student> students;

    public Yass(String name) {
        this.name = name;
        this.students = new ArrayList<>();


    }
    public void addStudent(Student st){
        this.students.add(st);
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

}
