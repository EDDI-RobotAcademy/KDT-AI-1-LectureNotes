package problems.prob12.q1Students;

import customLibrary.Random;

import java.util.ArrayList;

public class Student {
    int studentIndex;
    int score;
    int rank = 1;

    public Student(int studentIndex) {
        this.studentIndex = studentIndex;
        this.score = Random.randomNumber(0,100);
    }
    public void setRank(int rank) {
        this.rank = rank;
    }
    public int getRank() {
        return rank;
    }
    @Override
    public String toString() {
        return "Student{" +
                "studentIndex=" + studentIndex +
                ", score=" + score +
                ", rank=" + rank +
                '}';
    }
}


class Students {
    public int StudentsCount = 20;
    ArrayList<Student> students;

    public ArrayList<Student> getStudents() {
        return students;
    }
    public void setStudents(ArrayList<Student> students) {
        this.students = students;

    }

    public Students() { //학생들 만들기
        setStudents(new ArrayList<>());
        for(int i =0 ; i <StudentsCount; i++){
            students.add(new Student(i+1));
        }
    }

    public void AverageGrade(){ //평균구하기
        int sumGrade = 0;
        for(int i =0 ; i <StudentsCount; i++) {
            sumGrade += getStudents().get(i).score;
        }

        float averageGrade = sumGrade / StudentsCount;
        System.out.println("평균 점수 : " + averageGrade);

    }

    public void Rank(){ //랭크부여
        for(int i =0 ; i <StudentsCount; i++){

            for(int j =0 ; j <StudentsCount; j++) {
                if (students.get(i).score < students.get(j).score) { //기준학생보다 점수가 높은 학생이 있으면
                    int tmpRank = students.get(i).getRank() + 1;     // 등수 +1
                    students.get(i).setRank(tmpRank);
                }
            }
        }

        for(int i = 0; i <StudentsCount; i++) {
            System.out.println(students.get(i));
        }
    }

    public void LineUpRank(){ //랭크대로 정렬

        Student[] LineUpRankverList = new Student[StudentsCount];


        for(int i =0 ; i< StudentsCount; i++){

            for(int j =0 ; j< StudentsCount; j++){
                int rankNum = j+1;
                if (students.get(i).rank == rankNum) {
                    if(LineUpRankverList[j] != null){ //동점자 발생시
                        LineUpRankverList[j+1] = students.get(i); //바로 다음칸으로
                    } else{
                        LineUpRankverList[j] = students.get(i);}
                }
            }

        }

        //배열출력
        for(int i =0 ; i< LineUpRankverList.length; i++){
           System.out.println(LineUpRankverList[i]);
        }
    }


}

