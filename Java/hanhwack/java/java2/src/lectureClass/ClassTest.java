package lectureClass;

class Person {

    private Integer age;
    private String name;
    // 나이가 이름이 들어갈 변수 선언


    //생성자 작성
    //나이와 이름의 초기값 작성
    public Person() {
        this.age = 15;
        this.name = "Han";
        System.out.println("생성자 호출");
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }
}

public class ClassTest {
    public static void main(String[] args) {

        final Person person = new Person();

        System.out.println("이 사람의 나이는 " + person.getAge());
        System.out.println("이 사람의 이름은 " + person.getName());
        person.setAge(30);
        person.setName("Kim");
        System.out.println("이 사람의 나이는 " + person.getAge());
        System.out.println("이 사람의 이름은 " + person.getName());

    }
}
