package zfnsdlkfnlsdn;

public class Student {
    String studentName;
    int studentMoney;
    int grade;
    Bus busNumber;
    Subway subwayNumber;

    public Student(String studentName, int studentMoney, int grade) {
        this.studentName = studentName;
        this.studentMoney = studentMoney;
        this.grade = grade;
    }

    public void takeBus(Bus busNumber) {
        this.busNumber = busNumber;
        busNumber.take(1000);
        this.studentMoney -= 1000;
    }

    public void takeSubway(Subway subwayNumber) {
        this.subwayNumber = subwayNumber;
        subwayNumber.take(2000);
        this.studentMoney -= 2000;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", studentMoney=" + studentMoney +
                ", grade=" + grade +
                ", busNumber=" + busNumber +
                ", subwayNumber=" + subwayNumber +
                '}';
    }
}
