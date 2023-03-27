package lectureClass;
class Person{
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public int getAge() {return age;}

    public void setAge(int age) {this.age = age;}
}
public class PersonQuiz {
    public static void main(String[] args) {
        final Person person = new Person("김철수",20);

        // 초기 설정 값 출력
        System.out.println("이름 : " + person.getName());
        System.out.println("나이 : " + person.getAge());

        // 값 변경
        person.setName("홍길동");
        person.setAge(25);

        System.out.println();
        // 변경 후 출력
        System.out.println("이름 : " + person.getName());
        System.out.println("나이 : " + person.getAge());

    }
}
