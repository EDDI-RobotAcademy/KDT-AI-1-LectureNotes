package homework4;
import java.util.Scanner;

/*
3. Student(�л�) Ŭ������ �����ô�.
�л� �̸�, ����, ������ ǥ�����ּ���.
���������� Scanner ����ص� �ǰ� ���� �ʾƵ� �˴ϴ�.
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
		return  "�̸� : " + studentName + 
				"\n���� : " + studentAge + 
				"\n���� : " + studentMajor +
				"\n";
	}
	
	
}

public class classQuestion3 {
	public static void main(String[] args) {
		Student student1 = new Student("�趯��", 21, "�����");
		Student student2 = new Student("�̶���", 22, "�̼�������");
		Student student3 = new Student("�ڶ���", 23, "��ǻ�Ͱ��а�");
		Student student4 = new Student("�ֶ���", 24, "�濵�а�");
		
		int studentsTotalNumber = 10; //�л� �� �ο�
		Student studentsList [] = new Student [studentsTotalNumber]; //�л� �� �ο� = 10�� ��ŭ�� studentsList�迭�� �������
		
		studentsList[1] = student1;
		studentsList[2] = student2;
		studentsList[3] = student3;
		studentsList[4] = student4;
		
		boolean num = true; //�⺻�� while���ǹ� ����
		
		while (num) {
			Scanner scan1 = new Scanner(System.in);
			System.out.println("��ȸ�� �л���ȣ�� �Է��ϼ���. : \n���Ḧ ���ϸ� 0�� �Է��ϼ���.");	//�л� ��ȣ �Է¹ޱ�
			int studentNumber = scan1.nextInt();			
			System.out.println(studentsList[studentNumber]);//�л� ��ȣ�� �迭 ��ҿ� �ش��Ѵ� �л����� ���
			
			if (studentNumber == 0) {	//�Է� ���� 0�� ��
				num = false;			//while ���ǹ� ����
				System.out.println("���� �Ǿ����ϴ�.");		
			}			
		}
	}
}