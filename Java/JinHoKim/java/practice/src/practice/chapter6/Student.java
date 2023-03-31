package practice.chapter6;

public class Student {
    String studentName;
    int grade;
    int studentMoney;

    public Student(String studentName, int money) { // 학생 이름 & 학생이 가지고 있는 돈
        this.studentName = studentName;
        this.studentMoney = money;
    }

    public void takeBus(Bus busNumber) {
        busNumber.take(1000);
        studentMoney -= 1000;
    }

    public void takeSubway(Subway subway) {
        subway.take(2000);
        studentMoney -= 2000;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", grade=" + grade +
                ", studentMoney=" + studentMoney +
                '}';
    }
}

