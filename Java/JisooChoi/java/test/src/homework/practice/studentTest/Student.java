package homework.practice.studentTest;

import java.util.ArrayList;

public class Student {
    private String studentName; //이름
    private int studentId; //학번
    ArrayList<Subject> subjectList;//과목

    public Student(String studentName, int studentId){
        this.studentId = studentId;
        this.studentName = studentName;

        subjectList = new ArrayList<>();
    }

   public void addSubject(String name, int score){
        Subject subject = new Subject();
        subject.setName(name);
        subject.setScore(score);

       subjectList.add(subject);
   }

    public void showStudentInfo(){
        int total = 0;
        for(Subject subject : subjectList){
            total += subject.getScore();
            System.out.println("학생 "+studentName+"님의 "+subject.getName()+" 과목 성적은 " + subject.getScore()+ "점 입니다.");
        }
        System.out.println("학생 " +studentName+"님의 총점은 "+total+"점 입니다.");
    }
}
