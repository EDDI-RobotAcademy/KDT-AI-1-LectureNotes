package chapter1;

public class Student {
    int studentId;
    String studentName;
    int grade;
    String address;

    public Student() {} // 생성자는 반환 타입이 없다

    public Student(int id, String name){ //객체를 생성할 때 무조건 이 객체에 할 것을 적을 때 생성자를 사용
        studentId = id;
        studentName = name;
                                    //객체가 생성될때 수행되어야하는 명령어 코드
    } // 생성자는 클래스 이름하고 똑같아야한다 --> 디폴트 생성자(기본 생성자)

    public void showStudentInfo() {

        System.out.println(studentName + "," + address);
    }

    public String getStudentName() {

        return studentName;
    }

    public void setStudentName(String name) {

        studentName = name;
    }
}

