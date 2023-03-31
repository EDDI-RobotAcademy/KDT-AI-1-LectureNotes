package chapter1;

public class StudentTest {
    public static void main(String[] args) {
        Student studentLee = new Student(100, "이순신"); // 인스턴스 생성 new로 생성하기 //인스턴스화 객체 ->인스턴스 힙 메모리는 new 라는 키워드에 의해서 생성
        /*studentLee.studentName = "이순신"; // 참조변수 studentLee 는 Student 객체의 주소값을 가리킨다. 맴버변수는 Heap 메모리에 저장되지만 메서드는 다른곳에 저장된다
        studentLee.studentId = 100; */       // 객체를 좀더 자세하게 특정 짓는 것이 인스턴스 화 라고 이해할 수 있다. 학생 -> 학생 누구누구
        studentLee.address = "서울시 영등포구 여의도동";

        Student studentKim = new Student(); // Student();는 디폴트 생성자이다 Student 는 참조 변수 studentKim 의 객체 자료형 이다
        studentKim.studentName = "김진호";
        studentKim.studentId = 101;
        studentKim.address = "미국 산호세";

        studentLee.showStudentInfo();
        studentKim.showStudentInfo();
        System.out.println(studentKim); //참조변수는 힙 메모리에 생성된 주소값을 가리킨다
        System.out.println(studentLee); // 따라서 참조변수 . 을하면 access 할수있는 요소들을 참고할 수 있다.
    }
}
