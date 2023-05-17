import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    ArrayList<Integer> num = new ArrayList<>();
    //타입설정 int타입만 사용가능
    ArrayList<Integer> num2 = new ArrayList<>();
    //new에서 타입 파라미터 생략가능
    ArrayList<Integer> num3 = new ArrayList<Integer>(10);
    //초기 용량(capacity)지정

    public static void main(String[] args) {
        System.out.println("왜 main()은 new Why");




        ArrayList list = new ArrayList();
        //타입 미설정 Object로 선언된다.
        list.add(3);
        System.out.println(list);
        list.add(null);
        System.out.println(list);
        list.add(1,10);
        System.out.println(list);
        System.out.print('\n');

        list.remove(1);
        System.out.println(list);
        list.clear();
        System.out.println(list);


        ArrayList<Student> members = new ArrayList<Student>();
        //타입설정 Student객체만 사용가능
        members.add(new Student("장현민", 26));
        ArrayList<Integer> list2 = new ArrayList<Integer>(Arrays.asList(1,2,3));
        //생성시 값추가
        System.out.println(list2.get(0));
    }
}
class Student{
    public Student(String name, int age) {
    }
}