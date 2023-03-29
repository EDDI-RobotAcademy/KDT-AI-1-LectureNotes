package homework4;
import java.util.Scanner;

/*
3. Student(학생) 클래스를 만들어봅시다.
학생 이름, 나이, 전공을 표현해주세요.
마찬가지로 Scanner 사용해도 되고 하지 않아도 됩니다.
*/

class Student {
	String studentName;
	int studentAge;
	String studentMajor;
	
	Student(String studentName, int studentAge, String studentMajor) {
		this.studentName = studentName;
		this.studentAge = studentAge;
		this.studentMajor = studentMajor;
	}

	@Override
	public String toString() {
		return  "이름 : " + studentName + 
				"\n나이 : " + studentAge + 
				"\n전공 : " + studentMajor +
				"\n";
	}
	
	
}

public class classQuestion3 {
	public static void main(String[] args) {
		Student student1 = new Student("김땡땡", 21, "건축과");
		Student student2 = new Student("이땡땡", 22, "미술교육과");
		Student student3 = new Student("박땡땡", 23, "컴퓨터공학과");
		Student student4 = new Student("최땡땡", 24, "경영학과");
		
		int studentsTotalNumber = 10; //학생 총 인원
		Student studentsList [] = new Student [studentsTotalNumber]; //학생 총 인원 = 10개 만큼의 studentsList배열이 만들어짐
		
		studentsList[1] = student1;
		studentsList[2] = student2;
		studentsList[3] = student3;
		studentsList[4] = student4;
		
		boolean num = true; //기본값 while조건문 동작
		
		while (num) {
			Scanner scan1 = new Scanner(System.in);
			System.out.println("조회할 학생번호를 입력하세요. : \n종료를 원하면 0을 입력하세요.");	//학생 번호 입력받기
			int studentNumber = scan1.nextInt();			
			System.out.println(studentsList[studentNumber]);//학생 번호로 배열 요소에 해당한는 학생정보 출력
			
			if (studentNumber == 0) {	//입력 값이 0일 때
				num = false;			//while 조건문 정지
				System.out.println("종료 되었습니다.");		
			}			
		}
	}
}